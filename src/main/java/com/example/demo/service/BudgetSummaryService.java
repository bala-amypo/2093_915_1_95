package com.example.demo.service.impl;

import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    @Override
    public double calculateTotalBudget(List<Double> budgets) {
        if (budgets == null || budgets.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Double budget : budgets) {
            if (budget != null) {
                total += budget;
            }
        }
        return total;
    }

    // You can add more methods here as per your interface
}
