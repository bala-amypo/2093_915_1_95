package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BudgetPlan budgetPlan;

    private Double totalIncome;
    private Double totalExpense;
    private String status;
    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }
}
