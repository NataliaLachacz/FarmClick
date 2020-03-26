package com.farmclick.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

public enum UserAuthorities {

    USER(new SimpleGrantedAuthority("ROLE_USER")),
    ADMIN(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));

    @Getter
    private Collection<GrantedAuthority> authorities;

    UserAuthorities(GrantedAuthority... authorities) {
        this.authorities = Arrays.asList(authorities);
    }

}
