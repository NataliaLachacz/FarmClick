package com.farmclick.api.dto;

import com.farmclick.api.mapper.MappingTarget;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlantDTO implements MappingTarget<PlantDTO> {
    private String name;
    private BigDecimal value;
    private BigDecimal unlockCost;
}
