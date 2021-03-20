package com.farmclick.api.model;

import com.farmclick.security.UserAuthorities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private UserAuthorities authority;
}
