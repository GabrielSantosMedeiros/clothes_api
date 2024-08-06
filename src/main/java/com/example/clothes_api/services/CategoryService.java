package com.example.clothes_api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothes_api.models.Category;
import com.example.clothes_api.models.dtos.category.CategoryAddDTO;
import com.example.clothes_api.models.dtos.category.CategoryViewDTO;
import com.example.clothes_api.repositores.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private static CategoryRepository categoryRepository;

    public CategoryViewDTO addCategory(CategoryAddDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        categoryRepository.save(category);
        return new CategoryViewDTO(
            category.getId(),
            category.getName(),
            category.getCreatedAt(),
            category.getUpdatedAt()
        );
    }
}
