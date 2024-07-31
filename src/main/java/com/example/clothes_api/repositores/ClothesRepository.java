package com.example.clothes_api.repositores;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothes_api.models.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, UUID> {
    
}
