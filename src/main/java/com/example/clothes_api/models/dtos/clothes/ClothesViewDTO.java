package com.example.clothes_api.models.dtos.clothes;

import java.util.Set;
import java.time.LocalDateTime;

import com.example.clothes_api.models.dtos.image.ImageViewDTO;

public record ClothesViewDTO(
    String id,
    String name,
    Set<ImageViewDTO> images,
    String category,
    String occasion,
    String season,
    Double price,
    Long stock,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
