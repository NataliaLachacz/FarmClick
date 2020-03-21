package com.farmclick.api.controller;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.service.UserService;
import com.farmclick.api.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/getUserStats")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserStatsDTO getUserStats(@PathVariable Long id) {
        User user = userService.getUser(id);
        return UserTransformer.createUserStatsDTO(user);
    }
}
