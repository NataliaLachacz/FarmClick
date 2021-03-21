package com.farmclick.api.service;

import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO getUserById(Long id);
    UserDTO getUserByLogin(String login);

    UserDTO addUser(User user);

    Boolean removeUser(User user);
    Boolean removeUserById(Long id);

    UserDTO updateUser(User user);
}
