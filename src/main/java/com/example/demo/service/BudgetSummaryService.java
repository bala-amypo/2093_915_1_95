package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {
    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;
    
    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository, 
                                   BudgetPlanRepository budgetPlanRepository,
                                   TransactionLogRepository transactionLogRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }
    
    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        
        LocalDate startDate = LocalDate.of(plan.getYear(), plan.getMonth(), 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        
        List<TransactionLog> transactions = transactionLogRepository
            .findByUserAndTransactionDateBetween(plan.getUser(), startDate, endDate);
        
        double totalIncome = transactions.stream()
            .filter(t -> Category.TYPE_INCOME.equals(t.getCategory().getType()))
            .mapToDouble(TransactionLog::getAmount)
            .sum();
            
        double totalExpense = transactions.stream()
            .filter(t -> Category.TYPE_EXPENSE.equals(t.getCategory().getType()))
            .mapToDouble(TransactionLog::getAmount)
            .sum();
        
        String status = totalExpense <= plan.getExpenseLimit() ? 
            BudgetSummary.STATUS_UNDER_LIMIT : BudgetSummary.STATUS_OVER_LIMIT;
        
        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setStatus(status);
        summary.setGeneratedAt(LocalDateTime.now());
        
        return budgetSummaryRepository.save(summary);
    }
    
    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        return budgetSummaryRepository.findByBudgetPlan(plan).orElseThrow();
    }
}