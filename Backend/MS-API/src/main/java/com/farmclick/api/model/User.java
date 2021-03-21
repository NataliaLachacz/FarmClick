package com.farmclick.api.model;

import com.farmclick.api.mapper.MappingTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
@EqualsAndHashCode
public class User implements MappingTarget<User> {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_coins")
    private BigDecimal coins = new BigDecimal(0);

    @Column(name = "user_clicks")
    private Long clicks = 0L;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Plant> unlockedPlants = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
