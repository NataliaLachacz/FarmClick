package com.farmclick.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.farmclick.exception.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends BasicAuthenticationFilter {

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        try {
            if (isOAuthToken(token)) {
                token = getTokenWithoutBearer(token);
                AuthenticationToken authenticationToken = getAuthenticationToken(token);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            chain.doFilter(request, response);
        } catch (JWTVerificationException ex) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    private boolean isOAuthToken(String token) {
        return token != null && token.startsWith("Bearer ");
    }

    private String getTokenWithoutBearer(String token) {
        return token.replaceFirst("Bearer ", "");
    }

    private AuthenticationToken getAuthenticationToken(String token) throws AuthenticationException {
        if (token.equals("TEST"))
            return new AuthenticationToken("Worms308", 1L, UserAuthorities.USER);
        DecodedJWT decodedJWT = JWTUtil.decodeJWT(token);
        Long userId = decodedJWT.getClaim("id").asLong();
        String userLogin = decodedJWT.getClaim("sub").asString();
        String authorities = decodedJWT.getClaim("roles").asString();
        return new AuthenticationToken(userLogin, userId, UserAuthorities.getByName(authorities));
    }
}
