package com.example.clothes_api.services;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothes_api.models.dtos.clothes.ClothesAddDTO;
import com.example.clothes_api.models.dtos.clothes.ClothesViewDTO;
import com.example.clothes_api.repositores.ClothesRepository;
import com.example.clothes_api.repositores.ImageRepository;

@Service
public class ClothesService {
    
    @Autowired
    private static ClothesRepository clothesRepository;
    @Autowired
    private static ImageRepository imageRepository;

    public ClothesViewDTO addClothes(ClothesAddDTO dto) {

    }

    public List<ClothesViewDTO> getAll() {

    }

    public ClothesViewDTO getClothesById(UUID id) {

    }

    public ClothesViewDTO updateClothes(UUID id, ClothesAddDTO dto) {

    }

    public String deleteClothes(UUID id) {

    }
}
