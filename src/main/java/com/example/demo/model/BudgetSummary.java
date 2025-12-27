package com.example.demo.model;

import java.time.LocalDateTime;

public class BudgetSummary {
    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    private Long id;
    private BudgetPlan budgetPlan;
    private Double actualIncome;
    private Double actualExpense;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {}

    public BudgetSummary(Long id, BudgetPlan budgetPlan, Double actualIncome, Double actualExpense, String status, LocalDateTime generatedAt) {
        this.id = id;
        this.budgetPlan = budgetPlan;
        this.actualIncome = actualIncome;
        this.actualExpense = actualExpense;
        this.status = status;
        this.generatedAt = generatedAt;
    }

    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) { this.budgetPlan = budgetPlan; }
    public Double getActualIncome() { return actualIncome; }
    public void setActualIncome(Double actualIncome) { this.actualIncome = actualIncome; }
    public Double getActualExpense() { return actualExpense; }
    public void setActualExpense(Double actualExpense) { this.actualExpense = actualExpense; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}