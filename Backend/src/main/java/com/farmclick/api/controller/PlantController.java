package com.farmclick.api.controller;

import com.farmclick.api.dto.PlantDTO;
import com.farmclick.api.model.Plant;
import com.farmclick.api.service.PlantService;
import com.farmclick.api.transformer.PlantTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plant")
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlantDTO> getAllPlants(){
        return plantService.getAllPlants()
                .stream()
                .map(item -> new PlantTransformer().createDTO(item, PlantDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(params = "id")
    @ResponseStatus(HttpStatus.OK)
    public PlantDTO getPlantById(@RequestParam("id") Long id){
        return new PlantTransformer()
                .createDTO(plantService.getPlantById(id), PlantDTO.class);
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    public PlantDTO getPlantByName(@RequestParam("name") String name){
        return new PlantTransformer()
                .createDTO(plantService.getPlantByName(name), PlantDTO.class);
    }
}
