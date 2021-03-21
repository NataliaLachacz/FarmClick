package com.farmclick.api.dto;

import com.farmclick.api.mapper.MappingTarget;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserStatsDTO implements MappingTarget<UserStatsDTO> {
    private BigDecimal coins;
    private Long clicks;
}
