package com.example.loginapp.demo.service;

import com.example.loginapp.demo.models.User;
import com.example.loginapp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        // Lógica extra como encriptação de senha poderia ser adicionada aqui
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username); // busca pelo nome
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
    }
}
