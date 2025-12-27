package com.example.demo.repository.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BudgetPlanRepositoryImpl implements BudgetPlanRepository {
    private final Map<Long, BudgetPlan> budgetPlans = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public BudgetPlan save(BudgetPlan budgetPlan) {
        if (budgetPlan.getId() == null) {
            budgetPlan.setId(idGenerator.getAndIncrement());
        }
        budgetPlans.put(budgetPlan.getId(), budgetPlan);
        return budgetPlan;
    }

    @Override
    public Optional<BudgetPlan> findByUserAndMonthAndYear(User user, Integer month, Integer year) {
        return budgetPlans.values().stream()
                .filter(bp -> bp.getUser().getId().equals(user.getId()) && 
                             bp.getMonth().equals(month) && 
                             bp.getYear().equals(year))
                .findFirst();
    }
}