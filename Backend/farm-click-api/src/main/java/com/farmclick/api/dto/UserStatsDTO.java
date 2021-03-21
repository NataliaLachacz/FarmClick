package com.farmclick.api.dto;

import com.farmclick.api.mapper.Mappable;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserStatsDTO implements Mappable {
    private BigDecimal coins;
    private Long clicks;
}
