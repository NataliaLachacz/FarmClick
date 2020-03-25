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

    public static String createToken(User user, Long expirationTimeInSeconds) {
        long millis = System.currentTimeMillis();

        return JWT.create()
                .withSubject(user.getLogin())
                .withIssuer("ISSUER_TEST")
                .withClaim("roles", "ROLE_USER") //TODO roles
                .withIssuedAt(new Date(millis))
                .withExpiresAt(new Date(millis + (expirationTimeInSeconds * 1000)))
                .sign(Algorithm.HMAC512(password));
    }

    public static DecodedJWT decodeJWT(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(password))
                    .withIssuer("ISSUER_TEST")
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
}
