package com.example.demo.controller;

import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetSummaryController {

    private final BudgetSummaryService budgetSummaryService;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.budgetSummaryService = service;
    }

    @GetMapping("/summary")
    public String summary() {
        return budgetSummaryService.getSummary();
    }
}
