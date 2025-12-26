package com.example.demo.model;

import java.time.LocalDateTime;

public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";

    private Long id;
    private BudgetPlan budgetPlan;
    private Double income;
    private Double expense;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {}

    public BudgetSummary(Long id, BudgetPlan plan, Double inc, Double exp,
                         String status, LocalDateTime time) {
        this.id = id;
        this.budgetPlan = plan;
        this.income = inc;
        this.expense = exp;
        this.status = status;
        this.generatedAt = time;
    }

    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public void setBudgetPlan(BudgetPlan bp) { this.budgetPlan = bp; }
    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setStatus(String s) { this.status = s; }
    public String getStatus() { return status; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
}
