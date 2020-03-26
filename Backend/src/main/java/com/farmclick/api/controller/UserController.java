package com.farmclick.api.controller;

import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import com.farmclick.api.service.UserService;
import com.farmclick.api.transformer.GenericTransformer;
import com.farmclick.api.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    public UserStatsDTO getUserStats() {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByLogin(login);
        return new GenericTransformer<User, UserStatsDTO>().createDTO(user, UserStatsDTO.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(){
        Long authenticatedId = (Long) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        User user = userService.getUserById(authenticatedId);
        return new UserTransformer().createDTO(user, UserDTO.class);
    }

    @DeleteMapping("/${id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeUserById(@PathVariable Long id){
        userService.removeUserById(id);
    }

//    @DeleteMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void removeUser(User user){
//        userService.removeUser(user);
//    }
}
