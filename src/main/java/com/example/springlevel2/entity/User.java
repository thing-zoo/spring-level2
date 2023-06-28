package com.example.springlevel2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Entity
@Getter
public class User extends Timestamped {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    @Column(unique = true)
    private String username;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$")
    private String password;
}
