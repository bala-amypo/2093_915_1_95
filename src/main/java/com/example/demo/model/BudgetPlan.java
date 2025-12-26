package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public void validate() {
        if (month < 1 || month > 12)
            throw new BadRequestException("Invalid month");
    }
}
