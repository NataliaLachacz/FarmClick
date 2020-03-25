package com.farmclick.security;

import com.farmclick.api.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class AuthenticationToken extends AbstractAuthenticationToken {

//    private User authenticatedUser;
    private String login;

    public AuthenticationToken(String login, UserAuthorities authorities) {
        super(authorities.getAuthorities());
        this.login = login;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return login;
    }
}
