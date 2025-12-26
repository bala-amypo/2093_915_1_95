package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget-summary")
public class BudgetSummaryController {

    private final BudgetSummaryService budgetSummaryService;

    public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
        this.budgetSummaryService = budgetSummaryService;
    }

    @GetMapping
    public BudgetSummary getSummary(@RequestParam int month, @RequestParam int year) {
        return budgetSummaryService.getSummary(month, year);
    }
}
