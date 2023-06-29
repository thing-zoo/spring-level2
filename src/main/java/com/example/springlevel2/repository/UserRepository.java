package com.example.springlevel2.repository;

import com.example.springlevel2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
