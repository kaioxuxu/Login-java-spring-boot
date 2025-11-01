package com.example.loginapp.demo.controller;

import com.example.loginapp.demo.models.Product;
//import com.example.loginapp.demo.model.Product; // Mantenho comentado
import com.example.loginapp.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products") // Prefixo comum para rotas deste controller
public class ProductController {

    @Autowired // Injeção de dependência: o Spring injeta uma instância de ProductService
    private ProductService productService; // <-- CORREÇÃO: Declaração limpa

    @GetMapping // GET /products
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping // POST /products
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.save(newProduct);
    }

    @GetMapping("/{id}") // GET /products/{id}
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}") // PUT /products/{id}
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updated) {
        return productService.update(id, updated);
    }

    @DeleteMapping("/{id}") // DELETE /products/{id}
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}