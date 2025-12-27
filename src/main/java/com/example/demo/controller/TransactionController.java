package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/user/{userId}")
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