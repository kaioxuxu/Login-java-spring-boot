package com.example.loginapp.demo.controller;

import com.example.loginapp.demo.models.User;
import com.example.loginapp.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register") // POST /users/register
    public User register(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login") // POST /users/login
    public User login(@RequestBody User loginData) {
        return userService.login(loginData.getUsername(),loginData.getPassword());
    }
}