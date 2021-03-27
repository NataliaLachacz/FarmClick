package com.farmclick.api.mapper.custom;

import com.farmclick.api.dto.PlantDTO;
import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.mapper.CustomMapper;
import com.farmclick.api.model.User;

import java.util.stream.Collectors;

public class UserMapper implements CustomMapper<UserDTO, User> {

    @Override
    public UserDTO map(User entity) {
        UserDTO dto = CustomMapper.super.defaultMap(entity, UserDTO.class);
        dto.setUnlockedPlants(entity.getUnlockedPlants()
                .stream()
                .map(item -> item.map(PlantDTO.class))
                .collect(Collectors.toSet())
        );
        return dto;
    }
}
