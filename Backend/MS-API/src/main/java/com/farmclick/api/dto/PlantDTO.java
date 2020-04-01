package com.farmclick.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlantDTO {

    private String name;
    private BigDecimal value;
    private BigDecimal unlockCost;
}
