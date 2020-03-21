package com.farmclick.security;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HeadersAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthenticationToken token = (AuthenticationToken) authentication;
        User user = userService.getUser(token.getId());
        token.setAuthenticatedUser(user);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AuthenticationToken.class.isAssignableFrom(authentication);
    }
}
