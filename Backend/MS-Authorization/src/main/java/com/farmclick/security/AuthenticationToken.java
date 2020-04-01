package com.farmclick.security;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class AuthenticationToken extends AbstractAuthenticationToken {

    @Getter
    private Long id;
    @Getter
    private String login;

    public AuthenticationToken(String login, Long id, UserAuthorities authorities) {
        super(authorities.getAuthorities());
        setAuthenticated(true);
        this.login = login;
        this.id = id;
    }

    @Override
    public Object getCredentials() {
        return id;
    }

    @Override
    public Object getPrincipal() {
        return login;
    }
}
