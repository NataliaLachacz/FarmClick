package com.farmclick.api.controller;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.service.UserService;
import com.farmclick.api.transformer.UserTransformer;
import com.farmclick.security.AuthenticatedData;
import com.farmclick.security.AuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public UserStatsDTO getUserStats(@PathVariable Long id) {
//        User user = userService.getUser(id);
//        return UserTransformer.createUserStatsDTO(user);
//    }

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    public UserStatsDTO getUserStats() {
        User user = userService.getUser(AuthenticatedData.getAuthenticatedToken().getId());
        return UserTransformer.createUserStatsDTO(user);
    }
}
