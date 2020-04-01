package com.farmclick.api.service.impl;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.LoginService;
import com.farmclick.exception.LoginException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public User loginUser(String login, String password) {
        Optional<User> userByLogin = userRepository.findByLogin(login);
        if (userByLogin.isPresent()) {
            if (Objects.equals(password, userByLogin.get().getPassword())) {
                return userByLogin.get();
            } else {
                throw new LoginException("Invalid password.");
            }
        } else
            throw new LoginException("User with login [" + login + "] not found.");
    }
}
