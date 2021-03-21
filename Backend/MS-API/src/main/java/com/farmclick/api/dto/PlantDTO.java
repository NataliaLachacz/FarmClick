package com.farmclick.api.dto;

import com.farmclick.api.mapper.Mappable;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlantDTO implements Mappable {
    private String name;
    private BigDecimal value;
    private BigDecimal unlockCost;
}
