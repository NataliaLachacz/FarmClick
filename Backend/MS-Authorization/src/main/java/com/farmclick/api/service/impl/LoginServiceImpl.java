package com.farmclick.api.service.impl;

import com.farmclick.api.model.entity.User;
import com.farmclick.api.model.dto.AuthenticationToken;
import com.farmclick.api.model.dto.LoginCredentials;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.LoginService;
import com.farmclick.api.service.TokenService;
import com.farmclick.exception.LoginException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Override
    @Transactional
    public AuthenticationToken authenticateUser(LoginCredentials credentials) {
        Optional<User> user = userRepository.findByLogin(credentials.getLogin());
        if (user.isPresent()) {
            if (isPasswordCorrect(credentials, user.get())) {
                return getUserToken(user.get());
            } else {
                throw new LoginException("Invalid password.");
            }
        } else
            throw new LoginException("User with login [" + credentials.getLogin() + "] not found.");
    }

    private boolean isPasswordCorrect(LoginCredentials credentials, User user) {
        return BCrypt.checkpw(credentials.getPassword(), user.getPassword());
    }

    private AuthenticationToken getUserToken(User user) {
        String token = tokenService.createToken(user);
        return new AuthenticationToken(token);
    }
}
