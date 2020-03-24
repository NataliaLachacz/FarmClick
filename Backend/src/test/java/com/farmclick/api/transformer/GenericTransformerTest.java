package com.farmclick.api.transformer;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTransformerTest {

    @Test
    void shouldCreateUserFromDTOWithGeneric() {
        User user = new User();
        user.setLogin("Test");
        user.setClicks(250L);
        user.setCoins(new BigDecimal(15.0));

        UserStatsDTO userStatsDTO = new GenericTransformer<User, UserStatsDTO>().createDTO(user, UserStatsDTO.class);
        User userFromDTO = new GenericTransformer<User, UserStatsDTO>().createEntity(userStatsDTO, User.class);

        assertEquals(user, userFromDTO);
    }

    @Test
    void shouldCreateUserFromDTOWithDedicated() {
        User user = new User();
        user.setLogin("Test");
        user.setClicks(250L);
        user.setCoins(new BigDecimal(15.0));

        UserStatsDTO userStatsDTO = new UserStatsTransformer().createDTO(user, UserStatsDTO.class);
        User userFromDTO = new UserStatsTransformer().createEntity(userStatsDTO, User.class);

        assertEquals(user, userFromDTO);
    }
}
