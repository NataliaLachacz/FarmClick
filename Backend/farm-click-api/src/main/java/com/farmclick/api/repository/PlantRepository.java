package com.farmclick.api.repository;

import com.farmclick.api.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Optional<Plant> findByNameIgnoreCase(String name);
}
