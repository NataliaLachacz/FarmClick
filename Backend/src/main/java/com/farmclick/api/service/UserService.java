package com.farmclick.api.service;

import com.farmclick.api.model.User;
import com.farmclick.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUser(Long id);
}
