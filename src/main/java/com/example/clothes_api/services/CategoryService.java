package com.example.clothes_api.services;

import java.util.UUID;

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

    public CategoryViewDTO getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).get();
        return new CategoryViewDTO(
            category.getId(), 
            category.getName(), 
            category.getCreatedAt(), 
            category.getUpdatedAt()
        );
    }

    public CategoryViewDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name).get();
        return new CategoryViewDTO(
            category.getId(), 
            category.getName(), 
            category.getCreatedAt(), 
            category.getUpdatedAt()
        );
    }

    public CategoryViewDTO updateCategory(UUID id, CategoryAddDTO dto) {
        Category categoryUpdated = categoryRepository.findById(id).get();
        BeanUtils.copyProperties(dto, categoryUpdated);
        categoryRepository.save(categoryUpdated);
        return new CategoryViewDTO(
            categoryUpdated.getId(), 
            categoryUpdated.getName(), 
            categoryUpdated.getCreatedAt(), 
            categoryUpdated.getUpdatedAt()
        );
    }

    public String deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "category of name" + category.getName() + "has been deleted.";
    }
}
