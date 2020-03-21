package com.farmclick.api.transformer;

import com.farmclick.api.dto.UserStatsDTO;
import com.farmclick.api.model.User;
import org.springframework.beans.BeanUtils;

public class UserTransformer {

    public static UserStatsDTO createUserStatsDTO(User user){
        UserStatsDTO dto = new UserStatsDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
