package com.farmclick.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.farmclick.exception.AuthenticationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



public class JwtFilter extends BasicAuthenticationFilter {

    private Collection<String> excludeUrlPatterns = new ArrayList<>();

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        excludeUrlPatterns.add("/auth/login");
    }

    private AuthenticationToken getAuthenticationToken(String token) throws AuthenticationException {
        DecodedJWT decodedJWT = JWTUtil.decodeJWT(token);
        String userLogin = decodedJWT.getClaim("sub").asString();
        Long userId = decodedJWT.getClaim("id").asLong();
        return new AuthenticationToken(userLogin, userId, UserAuthorities.USER);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");

        try {
            AuthenticationToken authenticationToken = getAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (AuthenticationException ex){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return excludeUrlPatterns.stream()
                .anyMatch(p -> p.equals(request.getServletPath()));
    }
}
