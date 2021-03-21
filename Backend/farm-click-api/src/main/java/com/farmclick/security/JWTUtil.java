package com.farmclick.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.farmclick.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    private static byte[] password;

    public static DecodedJWT decodeJWT(String token) {
        try {
            if (token == null || token.isEmpty())
                throw new AuthenticationException("Empty token.");
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(password))
                    .withIssuer("APP")
                    .build();
            return verifier.verify(token);
        } catch (SignatureVerificationException ex) {
            throw new AuthenticationException("Invalid token.");
        }
    }

    @Value("${security.password}")
    public void setPassword(String pass) {
        password = pass.getBytes();
    }
}
