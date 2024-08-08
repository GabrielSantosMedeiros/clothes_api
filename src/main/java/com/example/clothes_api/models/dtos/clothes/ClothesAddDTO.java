package com.example.clothes_api.models.dtos.clothes;

import java.util.Set;

import com.example.clothes_api.models.dtos.image.ImageAddDTO;

public record ClothesAddDTO(
    String name,
    Set<ImageAddDTO> images, 
    String category,
    String occasion, 
    String season,
    Double price,
    Long stock
) {}
