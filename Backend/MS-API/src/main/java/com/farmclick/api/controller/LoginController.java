package com.farmclick.api.controller;

import com.auth0.jwt.JWT;
import com.farmclick.api.dto.LoginCredentialsDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.service.LoginService;
import com.farmclick.security.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginCredentialsDTO credentials, HttpServletResponse response){
        User authenticatedUser = loginService.loginUser(credentials.getLogin(), credentials.getPassword());

        String token = JWTUtil.createToken(authenticatedUser);
        response.setHeader("Authentication", token);
    }
}
