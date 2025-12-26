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

    public BudgetPlanServiceImpl(BudgetPlanRepository repo, UserRepository userRepo) {
        this.budgetPlanRepository = repo;
        this.userRepository = userRepo;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepository.findById(userId).orElseThrow();
        plan.validate();

        if (budgetPlanRepository
                .findByUserAndMonthAndYear(user, plan.getMonth(), 2025)
                .isPresent()) {
            throw new BadRequestException("Budget plan already exists");
        }

        return budgetPlanRepository.save(plan);
    }
}
