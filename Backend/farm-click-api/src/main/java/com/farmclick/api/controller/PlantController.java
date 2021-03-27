package com.farmclick.api.controller;

import com.farmclick.api.dto.PlantDTO;
import com.farmclick.api.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlantDTO> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping(params = "id")
    @ResponseStatus(HttpStatus.OK)
    public PlantDTO getPlantById(@RequestParam("id") Long id) {
        return plantService.getPlantById(id);
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    public PlantDTO getPlantByName(@RequestParam("name") String name) {
        return plantService.getPlantByName(name);
    }
}
