package com.example.demo.repository.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final Map<Long, Category> categories = new HashMap<>();
    private final Set<String> categoryNames = new HashSet<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public boolean existsByName(String name) {
        return categoryNames.contains(name);
    }

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(idGenerator.getAndIncrement());
        }
        categories.put(category.getId(), category);
        categoryNames.add(category.getName());
        return category;
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }
}