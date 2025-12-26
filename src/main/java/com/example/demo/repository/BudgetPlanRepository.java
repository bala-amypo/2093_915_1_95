package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanRepository {

    BudgetPlan save(BudgetPlan budgetPlan);

    BudgetPlan findByMonthAndYear(int month, int year);
}
