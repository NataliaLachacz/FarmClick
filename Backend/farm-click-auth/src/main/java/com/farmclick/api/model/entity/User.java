package com.farmclick.api.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Users")
@EqualsAndHashCode
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_email", nullable = false)
    @Email
    private String email;

    @Column(name = "user_coins")
    private BigDecimal coins = new BigDecimal(0);

    @Column(name = "user_clicks")
    private Long clicks = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
