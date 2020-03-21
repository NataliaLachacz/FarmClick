package com.farmclick.security;

import org.omg.IOP.ServiceContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.boot.context.properties.source.ConfigurationPropertyName.isValid;

public class HeadersAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String userID = httpServletRequest.getHeader("userID");

        if (!isValid(userID)){
            throw new SecurityException();
        }
        Long id = Long.valueOf(userID);
        Authentication authentication = new AuthenticationToken(id);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
