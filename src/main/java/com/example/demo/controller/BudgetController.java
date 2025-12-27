package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    @PostMapping
    public BudgetPlan create(@RequestBody BudgetPlan plan) {
        return budgetPlanService.createOrUpdate(plan);
    }

    @GetMapping
    public BudgetPlan get(@RequestParam int month, @RequestParam int year) {
        return budgetPlanService.getPlan(month, year);
    }
}
