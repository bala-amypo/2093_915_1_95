package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionLog add(@RequestBody TransactionLog transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<TransactionLog> getAll() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/filter")
    public List<TransactionLog> filter(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return transactionService.getTransactionsBetween(start, end);
    }
}
