package com.farmclick.api.service.impl;

import com.farmclick.api.dto.PlantDTO;
import com.farmclick.api.repository.PlantRepository;
import com.farmclick.api.service.PlantService;
import com.farmclick.exception.PlantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public List<PlantDTO> getAllPlants() {
        return plantRepository.findAll()
                .stream()
                .map(plant -> plant.transform(PlantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlantDTO getPlantById(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException("Plant with id [" + id + "] not found."))
                .transform(PlantDTO.class);
    }

    @Override
    public PlantDTO getPlantByName(String name) {
        return plantRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new PlantNotFoundException("Plant with name [" + name + "] not found."))
                .transform(PlantDTO.class);
    }
}
