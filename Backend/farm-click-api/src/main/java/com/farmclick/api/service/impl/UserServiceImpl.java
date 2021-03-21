package com.farmclick.api.service.impl;

import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.UserService;
import com.farmclick.api.mapper.custom.UserMapper;
import com.farmclick.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found."))
                .map(new UserMapper());
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User with login [" + login + "] not found."))
                .map(UserDTO.class);
    }

    @Override
    public UserDTO addUser(User user) {
        return userRepository.save(user)
                .map(UserDTO.class);
    }

    @Override
    public Boolean removeUser(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public Boolean removeUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id [" + id + "] not found."));
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserDTO updateUser(User user) {
        Optional<User> fromDb = userRepository.findByLogin(user.getLogin());
        if (fromDb.isPresent()){
            user.setId(fromDb.get().getId());
            return userRepository.save(user)
                    .map(UserDTO.class);
        } else {
            throw new UserNotFoundException("User with login [" + user.getLogin() + "] not found.");
        }
    }
}
