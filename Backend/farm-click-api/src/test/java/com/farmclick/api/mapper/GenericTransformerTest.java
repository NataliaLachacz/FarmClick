package com.farmclick.api.mapper;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTransformerTest {

    @Test
    void shouldCreateUserFromDTOWithGeneric() {
        User user = new User();
        user.setClicks(250L);
        user.setCoins(new BigDecimal("15.0"));

        UserStatsDTO userStatsDTO = user.map(UserStatsDTO.class);
        User userFromDTO = userStatsDTO.map(User.class);

        assertEquals(user, userFromDTO);
    }
}
