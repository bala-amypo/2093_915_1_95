package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category createCategory(Category category) {
        if (repository.existsByName(category.getName())) {
            throw new BadRequestException("Category already exists");
        }
        category.validateType();
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }
}
