package com.example.demo.repository.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BudgetSummaryRepositoryImpl implements BudgetSummaryRepository {
    private final Map<Long, BudgetSummary> budgetSummaries = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public BudgetSummary save(BudgetSummary budgetSummary) {
        if (budgetSummary.getId() == null) {
            budgetSummary.setId(idGenerator.getAndIncrement());
        }
        budgetSummaries.put(budgetSummary.getId(), budgetSummary);
        return budgetSummary;
    }

    @Override
    public Optional<BudgetSummary> findByBudgetPlan(BudgetPlan budgetPlan) {
        return budgetSummaries.values().stream()
                .filter(bs -> bs.getBudgetPlan().getId().equals(budgetPlan.getId()))
                .findFirst();
    }
}