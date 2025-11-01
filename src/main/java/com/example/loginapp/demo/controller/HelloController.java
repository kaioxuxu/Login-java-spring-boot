package com.example.loginapp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é um Controller REST, retornando dados (não views)
public class HelloController {

    @GetMapping("/hello") // Mapeia requisições HTTP GET para o método abaixo
    public String hello() {
        return "Olá, Spring Boot!"; // Retorna texto simples ao acessar / hello
    }
}
