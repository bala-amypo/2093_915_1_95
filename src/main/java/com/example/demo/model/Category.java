package com.example.demo.model;

import com.example.demo.exception.BadRequestException;

public class Category {
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    private Long id;
    private String name;
    private String type;

    public Category() {}

    public Category(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void validateType() {
        if (!TYPE_INCOME.equals(type) && !TYPE_EXPENSE.equals(type)) {
            throw new BadRequestException("Invalid category type");
        }
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
}
