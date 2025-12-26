package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId).orElseThrow();
        if (repo.findByUserAndMonthAndYear(user, plan.getMonth(), plan.getYear()).isPresent()) {
            throw new BadRequestException("Budget plan exists");
        }
        plan.validate();
        plan.setUser(user);
        return repo.save(plan);
    }
}
