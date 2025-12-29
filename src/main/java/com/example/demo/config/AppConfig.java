package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider("MySuperSecretJwtKeyForBudgetPlanner123456", 3600000L);
    }

    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserServiceImpl(userRepository, passwordEncoder);
    }
    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryServiceImpl(categoryRepository);
    }

    @Bean
    public TransactionService transactionService(TransactionLogRepository transactionLogRepository, UserRepository userRepository) {
        return new TransactionServiceImpl(transactionLogRepository, userRepository);
    }

    @Bean
    public BudgetPlanService budgetPlanService(BudgetPlanRepository budgetPlanRepository, UserRepository userRepository) {
        return new BudgetPlanServiceImpl(budgetPlanRepository, userRepository);
    }

    @Bean
    public BudgetSummaryService budgetSummaryService(BudgetSummaryRepository budgetSummaryRepository, 
                                                   BudgetPlanRepository budgetPlanRepository,
                                                   TransactionLogRepository transactionLogRepository) {
        return new BudgetSummaryServiceImpl(budgetSummaryRepository, budgetPlanRepository, transactionLogRepository);
    }
}