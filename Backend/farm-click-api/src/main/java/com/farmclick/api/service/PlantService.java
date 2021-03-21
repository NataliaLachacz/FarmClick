package com.farmclick.api.service;

import com.farmclick.api.dto.PlantDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantService {

    List<PlantDTO> getAllPlants();
    PlantDTO getPlantById(Long id);
    PlantDTO getPlantByName(String name);
}
