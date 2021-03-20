package com.farmclick.api.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginCredentials {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}
