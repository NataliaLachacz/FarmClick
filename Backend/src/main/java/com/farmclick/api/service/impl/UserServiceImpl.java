package com.farmclick.api.service.impl;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.UserService;
import com.farmclick.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found."));
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UserNotFoundException("User with login [" + login + "] not found."));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean removeUser(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public Boolean removeUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found."));
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> fromDb = userRepository.findByLogin(user.getLogin());
        if (fromDb.isPresent()){
            user.setId(fromDb.get().getId());
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User with login [" + user.getLogin() + "] not found.");
        }
    }
}
