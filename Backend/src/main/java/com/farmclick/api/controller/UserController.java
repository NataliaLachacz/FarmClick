package com.farmclick.api.controller;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.service.UserService;
import com.farmclick.api.transformer.GenericTransformer;
import com.farmclick.security.AuthenticatedData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    public UserStatsDTO getUserStats() {
        User user = userService.getUser(AuthenticatedData.getAuthenticatedToken().getId());
        return new GenericTransformer<User, UserStatsDTO>().createDTO(user, UserStatsDTO.class);
    }
}
