package com.farmclick.api.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.farmclick.api.model.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface TokenService {

    String createToken(User user);

    DecodedJWT decodeJWT(String token);
}
