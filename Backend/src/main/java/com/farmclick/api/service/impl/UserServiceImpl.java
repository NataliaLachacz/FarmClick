package com.farmclick.api.service.impl;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.UserService;
import com.farmclick.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found."));
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UserNotFoundException("User with login [" + login + "] not found."));
    }
}
