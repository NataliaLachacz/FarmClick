package com.farmclick.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class UserDTO {

    private String login;
    private String email;
    private BigDecimal coins;
    private Long clicks;
    private Set<PlantDTO> unlockedPlants;
}
