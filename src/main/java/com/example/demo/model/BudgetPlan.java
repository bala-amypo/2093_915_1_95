package com.example.demo.model;

import com.example.demo.exception.BadRequestException;

public class BudgetPlan {
    private Long id;
    private User user;
    private Integer month;
    private Integer year;
    private Double plannedIncome;
    private Double plannedExpense;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year, Double plannedIncome, Double plannedExpense) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.plannedIncome = plannedIncome;
        this.plannedExpense = plannedExpense;
    }

    public void validate() {
        if (month == null || month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public Double getPlannedIncome() { return plannedIncome; }
    public void setPlannedIncome(Double plannedIncome) { this.plannedIncome = plannedIncome; }
    public Double getPlannedExpense() { return plannedExpense; }
    public void setPlannedExpense(Double plannedExpense) { this.plannedExpense = plannedExpense; }
}