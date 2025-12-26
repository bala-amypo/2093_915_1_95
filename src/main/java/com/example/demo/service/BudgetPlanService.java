package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createOrUpdate(BudgetPlan plan);

    BudgetPlan getPlan(int month, int year);
}
