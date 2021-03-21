package com.farmclick.api.dto;

import com.farmclick.api.mapper.Mappable;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class UserDTO implements Mappable {
    private String login;
    private String email;
    private BigDecimal coins;
    private Long clicks;
    private Set<PlantDTO> unlockedPlants;
}
