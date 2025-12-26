package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import java.time.LocalDate;

public class TransactionLog {

    private Long id;
    private User user;
    private Category category;
    private Double amount;
    private String note;
    private LocalDate transactionDate;

    public TransactionLog() {}

    public TransactionLog(Long id, User user, Category category,
                          Double amount, String note, LocalDate date) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.transactionDate = date;
    }

    public void validate() {
        if (amount <= 0)
            throw new BadRequestException("Invalid amount");
        if (transactionDate.isAfter(LocalDate.now()))
            throw new BadRequestException("Future date");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public Category getCategory() { return category; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setTransactionDate(LocalDate d) { this.transactionDate = d; }
}
