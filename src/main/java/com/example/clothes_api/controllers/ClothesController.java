package com.example.clothes_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothes_api.models.Clothes;
import com.example.clothes_api.repositores.ClothesRepository;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    
    @Autowired
    private ClothesRepository clothesRepository;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Clothes clothing) {
        clothesRepository.save(clothing);
        return ResponseEntity.status(201).body(clothing);
    }

    @GetMapping
    public List<Clothes> getAll() {
        return clothesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClothing(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(clothesRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClothing(@PathVariable(name = "id") Long id, @RequestBody Clothes clothing) {
        Clothes oldClothing = clothesRepository.findById(id).get();
        oldClothing = clothing;
        clothesRepository.save(oldClothing);
        return ResponseEntity.status(200).body(oldClothing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Clothes clothing = clothesRepository.findById(id).get();
        clothesRepository.delete(clothing);
        return ResponseEntity.status(204).body("this clothing has been deleted.");
    }
}
