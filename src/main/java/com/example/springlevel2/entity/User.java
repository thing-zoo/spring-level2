package com.example.springlevel2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends Timestamped {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

}
