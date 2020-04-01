package com.farmclick.api.transformer;

import com.farmclick.api.dto.PlantDTO;
import com.farmclick.api.dto.UserDTO;
import com.farmclick.api.model.User;

import java.util.stream.Collectors;

public class UserTransformer extends GenericTransformer<User, UserDTO> {
    @Override
    public UserDTO createDTO(User user, Class<UserDTO> userDTOClass) {
        UserDTO dto = super.createDTO(user, userDTOClass);
        dto.setUnlockedPlants(user.getUnlockedPlants()
                .stream()
                .map(item -> new PlantTransformer().createDTO(item, PlantDTO.class))
                .collect(Collectors.toSet())
        );
        return dto;
    }
}
