package com.example.clothes_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothes_api.repositores.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private static CategoryRepository CategoryRepository;


}
