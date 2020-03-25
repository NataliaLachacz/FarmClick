package com.farmclick.api.service;

import com.farmclick.api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    User loginUser(String login, String password);
}
