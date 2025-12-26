package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repository;

    public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetPlan createOrUpdate(BudgetPlan plan) {
        plan.validate();
        return repository.save(plan);
    }

    @Override
    public BudgetPlan getPlan(int month, int year) {
        return repository.findByMonthAndYear(month, year)
                .orElseThrow(() -> new BadRequestException("Plan not found"));
    }
}
