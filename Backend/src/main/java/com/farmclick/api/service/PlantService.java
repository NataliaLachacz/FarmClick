package com.farmclick.api.service;

import com.farmclick.api.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantService {

    List<Plant> getAllPlants();
    Plant getPlantById(Long id);
    Plant getPlantByName(String name);
}
