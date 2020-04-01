package com.farmclick.api.service;

import com.farmclick.api.model.User;
import com.farmclick.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(Long id);
    User getUserByLogin(String login);

    User addUser(User user);

    Boolean removeUser(User user);
    Boolean removeUserById(Long id);

    User updateUser(User user);
}
