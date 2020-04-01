package com.farmclick.api.service.impl;

import com.farmclick.api.model.Plant;
import com.farmclick.api.repository.PlantRepository;
import com.farmclick.api.service.PlantService;
import com.farmclick.exception.PlantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElseThrow(()->new PlantNotFoundException("Plant with id [" + id + "] not found."));
    }

    @Override
    public Plant getPlantByName(String name) {
        return plantRepository.findByNameIgnoreCase(name).orElseThrow(()->new PlantNotFoundException("Plant with name [" + name + "] not found."));
    }
}
