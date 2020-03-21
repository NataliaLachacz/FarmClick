package com.farmclick.security;

import com.farmclick.api.model.User;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class AuthenticationToken extends AbstractAuthenticationToken {

    private User authenticatedUser;
    @Getter
    private Long id;

    public AuthenticationToken(Long id) {
        super(null);
        this.id = id;
    }

    public void setAuthenticatedUser(User user){
        authenticatedUser = user;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return authenticatedUser;
    }
}
