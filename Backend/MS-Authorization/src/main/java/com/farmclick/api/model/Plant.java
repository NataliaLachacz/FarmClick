package com.farmclick.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Plants")
@EqualsAndHashCode
public class Plant {

    @Id
    @Column(name = "plant_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plant_name", nullable = false, unique = true)
    private String name;

    @Column(name = "plant_filename", unique = true)
    private String filename;

    @Column(name = "plant_value", nullable = false)
    private BigDecimal value;

    @Column(name = "plant_unlock_cost", nullable = false)
    private BigDecimal unlockCost;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
