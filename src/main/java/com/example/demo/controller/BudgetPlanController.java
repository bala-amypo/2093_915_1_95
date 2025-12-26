package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {
    private final BudgetPlanService budgetPlanService;
    
    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }
    
    @PostMapping("/{userId}")
    public ResponseEntity<BudgetPlan> createBudgetPlan(@PathVariable Long userId, @RequestBody BudgetPlan budgetPlan) {
        BudgetPlan savedPlan = budgetPlanService.createBudgetPlan(userId, budgetPlan);
        return ResponseEntity.ok(savedPlan);
    }
    
    @GetMapping("/{userId}/{month}/{year}")
    public ResponseEntity<BudgetPlan> getBudgetPlan(@PathVariable Long userId, @PathVariable Integer month, @PathVariable Integer year) {
        BudgetPlan plan = budgetPlanService.getBudgetPlan(userId, month, year);
        return ResponseEntity.ok(plan);
    }
}