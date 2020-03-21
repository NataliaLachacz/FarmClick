package com.farmclick.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticatedData {

    public static AuthenticationToken getAuthenticatedToken(){
        return (AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
