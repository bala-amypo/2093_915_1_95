package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @Autowired
    private BudgetPlanService budgetPlanService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<BudgetPlan> createBudgetPlan(@PathVariable Long userId, @RequestBody BudgetPlan budgetPlan) {
        BudgetPlan savedPlan = budgetPlanService.createBudgetPlan(userId, budgetPlan);
        return ResponseEntity.ok(savedPlan);
    }
}