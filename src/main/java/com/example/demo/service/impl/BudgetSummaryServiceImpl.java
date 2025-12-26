package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository logRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo,
                                    TransactionLogRepository logRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.logRepo = logRepo;
    }

    @Override
    public BudgetSummary createSummary(BudgetSummary summary) {
        return summaryRepo.save(summary);
    }

    @Override
    public List<BudgetSummary> getAllSummaries() {
        return summaryRepo.findAll();
    }

    @Override
    public Optional<BudgetSummary> getSummaryById(Long id) {
        return summaryRepo.findById(id);
    }

    @Override
    public BudgetSummary updateSummary(Long id, BudgetSummary updatedSummary) {
        return summaryRepo.findById(id).map(summary -> {
            summary.setTotalIncome(updatedSummary.getTotalIncome());
            summary.setTotalExpense(updatedSummary.getTotalExpense());
            summary.setMonth(updatedSummary.getMonth());
            summary.setYear(updatedSummary.getYear());
            return summaryRepo.save(summary);
        }).orElseThrow(() -> new RuntimeException("BudgetSummary not found with id: " + id));
    }

    @Override
    public void deleteSummary(Long id) {
        summaryRepo.deleteById(id);
    }

    @Override
    public BudgetSummary calculateSummaryForPlan(Long planId) {
        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() -> new RuntimeException("BudgetPlan not found with id: " + planId));

        double totalIncome = logRepo.sumIncomeByPlan(planId);
        double totalExpense = logRepo.sumExpenseByPlan(planId);

        BudgetSummary summary = new BudgetSummary();
        summary.setPlan(plan);
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setMonth(plan.getMonth());
        summary.setYear(plan.getYear());

        return summaryRepo.save(summary);
    }
}
