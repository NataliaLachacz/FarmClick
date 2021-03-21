package com.farmclick.api.service;

import com.farmclick.api.model.dto.AuthenticationToken;
import com.farmclick.api.model.dto.LoginCredentials;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    AuthenticationToken authenticateUser(LoginCredentials loginCredentials);
}
