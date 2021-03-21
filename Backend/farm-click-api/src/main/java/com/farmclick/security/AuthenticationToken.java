package com.farmclick.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
@EqualsAndHashCode(callSuper = true)
public class AuthenticationToken extends AbstractAuthenticationToken {
    private final Long id;
    private final String login;

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
