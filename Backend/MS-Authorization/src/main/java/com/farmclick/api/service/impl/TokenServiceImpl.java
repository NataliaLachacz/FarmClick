package com.farmclick.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.farmclick.api.model.entity.User;
import com.farmclick.api.service.TokenService;
import com.farmclick.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${security.password}")
    private byte[] password;
    @Value("${security.expiration.time}")
    private Long expirationTime;

    public String createToken(User user) {
        long millis = System.currentTimeMillis();

        return "Bearer " + JWT.create()
                .withSubject(user.getLogin())
                .withIssuer("APP")
                .withClaim("id", user.getId())
                .withClaim("roles", user.getRole().getAuthority().name())
                .withIssuedAt(new Date(millis))
                .withExpiresAt(new Date(millis + (expirationTime * 1000)))
                .sign(Algorithm.HMAC512(password));
    }

    public DecodedJWT decodeJWT(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(password))
                    .withIssuer("APP")
                    .build();
            return verifier.verify(token);
        } catch (SignatureVerificationException ex) {
            throw new AuthenticationException("Invalid token.");
        }
    }
}
