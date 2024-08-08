package com.example.clothes_api.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothes_api.models.dtos.category.CategoryAddDTO;
import com.example.clothes_api.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private static CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryAddDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") String id) {
        UUID uuid = UUID.fromString(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(uuid));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody CategoryAddDTO dto) {
        UUID uuid = UUID.fromString(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(uuid, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        UUID uuid = UUID.fromString(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categoryService.deleteCategory(uuid));
    }
}
