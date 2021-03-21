package com.farmclick.api.controller;

import com.farmclick.TestBase;
import com.farmclick.api.model.dto.LoginCredentials;
import com.farmclick.api.model.entity.Role;
import com.farmclick.api.model.entity.User;
import com.farmclick.api.repository.RoleRepository;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.security.UserAuthorities;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LoginControllerTest extends TestBase {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        Role user = initUserRole();
        String salt = BCrypt.gensalt();
        User worms = initUser("Worms308", BCrypt.hashpw("password", salt), user);
        insertUsers(worms);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void should_login_as_worms308() throws Exception {
        // Given
        LoginCredentials wormsCredentials = new LoginCredentials();
        wormsCredentials.setLogin("Worms308");
        wormsCredentials.setPassword("password");

        // When
        mvc.perform(post("/login")
                .content(new Gson().toJson(wormsCredentials))
                .contentType(MediaType.APPLICATION_JSON))

        // Then
                .andExpect(status().isOk())
                .andExpect(header().exists("Authorization"));
    }

    private User initUser(String login, String password, Role role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail("email");
        user.setCoins(new BigDecimal("1"));
        user.setClicks(1L);
        user.setRole(role);
        return user;
    }

    private void insertUser(User user){
        if (!userRepository.findByLogin(user.getLogin()).isPresent())
            userRepository.save(user);
    }

    private void insertUsers(User... users){
        Arrays.stream(users).forEach(this::insertUser);
    }

    private Role initUserRole() {
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setAuthority(UserAuthorities.USER);

        return roleRepository.save(role);
    }
}