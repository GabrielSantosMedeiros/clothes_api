package com.example.clothes_api.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.example.clothes_api.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID>{
    
}
