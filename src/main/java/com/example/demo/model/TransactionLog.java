package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import java.time.LocalDate;

public class TransactionLog {
    private Long id;
    private User user;
    private Category category;
    private Double amount;
    private String description;
    private LocalDate transactionDate;

    public TransactionLog() {}

    public TransactionLog(Long id, User user, Category category, Double amount, String description, LocalDate transactionDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public void validate() {
        if (transactionDate != null && transactionDate.isAfter(LocalDate.now())) {
            throw new BadRequestException("Transaction date cannot be in the future");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
}