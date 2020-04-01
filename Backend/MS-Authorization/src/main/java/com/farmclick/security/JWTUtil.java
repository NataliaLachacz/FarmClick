package com.farmclick.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.farmclick.api.model.User;
import com.farmclick.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static byte[] password;
    private static Long expirationTime;

    public static String createToken(User user) {
        long millis = System.currentTimeMillis();

        return JWT.create()
                .withSubject(user.getLogin())
                .withIssuer("APP")
                .withClaim("id", user.getId())
                .withClaim("roles", user.getRole().getName())
                .withIssuedAt(new Date(millis))
                .withExpiresAt(new Date(millis + (expirationTime * 1000)))
                .sign(Algorithm.HMAC512(password));
    }

    public static DecodedJWT decodeJWT(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(password))
                    .withIssuer("APP")
                    .build();
            return verifier.verify(token);
        } catch (SignatureVerificationException ex){
            throw new AuthenticationException("Invalid token.");
        }
    }

    @Value("${security.password}")
    public void setPassword(String pass) {
        password = pass.getBytes();
    }

    @Value("${security.expiration.time}")
    public void setExpirationTime(Long expTime){
        expirationTime = expTime;
    }
}
