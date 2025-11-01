package com.example.loginapp.demo.service;

import com.example.loginapp.demo.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>(); // Exemplo usandolista em memória

    public List<Product> findAll() {
        return products;
    }

    public Product save(Product p) {
        // Lógica simples: adiciona à lista e retorna
        p.setId((long) (products.size() + 1));
        products.add(p);
        return p;
    }

    public Product findById(Long id) {
        Optional<Product> found = products.stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst();
        return found.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Product update(Long id, Product updated) {
        Product existing = findById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        return existing;
    }

    public void delete(Long id) {
        Product existing = findById(id);
        products.remove(existing);
    }
}