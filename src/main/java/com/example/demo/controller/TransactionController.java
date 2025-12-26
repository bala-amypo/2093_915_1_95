package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping("/{userId}")
    public ResponseEntity<TransactionLog> addTransaction(@PathVariable Long userId, @RequestBody TransactionLog transaction) {
        TransactionLog savedTransaction = transactionService.addTransaction(userId, transaction);
        return ResponseEntity.ok(savedTransaction);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionLog>> getUserTransactions(@PathVariable Long userId) {
        List<TransactionLog> transactions = transactionService.getUserTransactions(userId);
        return ResponseEntity.ok(transactions);
    }
}