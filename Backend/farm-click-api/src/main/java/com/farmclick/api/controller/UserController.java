package com.farmclick.api.controller;

import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    public UserStatsDTO getUserStats() {
        Long authenticatedId = (Long) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return userService.getUserById(authenticatedId)
                .map(UserStatsDTO.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser() {
        Long authenticatedId = (Long) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return userService.getUserById(authenticatedId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUserById(@PathVariable Long id){
        userService.removeUserById(id);
    }
}
