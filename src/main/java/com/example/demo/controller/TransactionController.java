package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{userId}")
    public TransactionLog addTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionLog transactionLog) {

        return transactionService.addTransaction(userId, transactionLog);
    }
}
