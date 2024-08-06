package com.example.clothes_api.models.dtos.category;

import java.time.LocalDateTime;

public record CategoryViewDTO(
    String id, 
    String name,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
