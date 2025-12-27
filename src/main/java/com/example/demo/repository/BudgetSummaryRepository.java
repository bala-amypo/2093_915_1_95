package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import java.util.Optional;

public interface BudgetSummaryRepository {
    BudgetSummary save(BudgetSummary budgetSummary);
    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan budgetPlan);
}