package com.example.demo.model;

import com.example.demo.exception.BadRequestException;

public class BudgetPlan {

    private Long id;
    private User user;
    private Integer month;
    private Integer year;
    private Double incomeLimit;
    private Double expenseLimit;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year,
                      Double income, Double expense) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeLimit = income;
        this.expenseLimit = expense;
    }

    public void validate() {
        if (month < 1 || month > 12)
            throw new BadRequestException("Invalid month");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getMonth() { return month; }
    public User getUser() { return user; }
}
