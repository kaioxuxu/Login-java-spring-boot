package com.example.loginapp.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
// Marca a classe como entidade JPA, mapeada para uma tabela
// @Table(name="users") // Nome da tabela no banco (opcional se for igual aonome
// da classe)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chave primária auto-incremento
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}