package com.farmclick.api.controller;

import com.farmclick.api.model.User;
import com.farmclick.api.repository.UserRepository;
import com.farmclick.api.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @InjectMocks
//    private WebApplicationContext webApplicationContext;
//    @MockBean
//    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        userRepository.deleteAll();
        userRepository.flush();
    }

    @Test
    public void shouldGetUser() throws Exception {
        mockMvc.perform(
                get("/api/user/stats")
                        .header("userID", "1"))
                .andExpect(status().isOk());
    }

//    private User initUser(String login, String password, String email, BigDecimal coins, Long clicks) {
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setEmail(email);
//        user.setCoins(coins);
//        user.setClicks(clicks);
//
//        userRepository.saveAndFlush(user);
//        return user;
//    }
}
