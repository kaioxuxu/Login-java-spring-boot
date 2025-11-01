package com.example.loginapp.demo.repository;

import com.example.loginapp.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Método de consulta derivado por nome
}
