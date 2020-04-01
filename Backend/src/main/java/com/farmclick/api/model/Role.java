package com.farmclick.api.model;

import com.farmclick.security.UserAuthorities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Role")
@EqualsAndHashCode
public class Role {

    @Id
    @Column(name = "role_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    @Column(name = "role_authority", nullable = false)
    private UserAuthorities authority;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
