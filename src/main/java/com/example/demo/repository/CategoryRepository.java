package com.example.demo.repository;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryRepository {
    boolean existsByName(String name);
    Category save(Category category);
    List<Category> findAll();
}
