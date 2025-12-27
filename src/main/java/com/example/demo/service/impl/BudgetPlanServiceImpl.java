package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {
    private final BudgetPlanRepository budgetPlanRepository;
    private final UserRepository userRepository;

    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository, UserRepository userRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan budgetPlan) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        
        if (budgetPlanRepository.findByUserAndMonthAndYear(user, budgetPlan.getMonth(), budgetPlan.getYear()).isPresent()) {
            throw new BadRequestException("Budget plan already exists for this month and year");
        }
        
        budgetPlan.setUser(user);
        return budgetPlanRepository.save(budgetPlan);
    }
}