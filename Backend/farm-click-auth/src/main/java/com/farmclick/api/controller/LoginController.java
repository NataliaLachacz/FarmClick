package com.farmclick.api.controller;

import com.farmclick.api.model.dto.AuthenticationToken;
import com.farmclick.api.model.dto.LoginCredentials;
import com.farmclick.api.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Validated
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationToken login(@Validated @RequestBody LoginCredentials credentials) {
        return loginService.authenticateUser(credentials);
    }
}
