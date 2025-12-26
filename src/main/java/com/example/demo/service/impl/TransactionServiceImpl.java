package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repository;

    public TransactionServiceImpl(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionLog addTransaction(TransactionLog log) {
        log.validate();
        return repository.save(log);
    }

    @Override
    public List<TransactionLog> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public List<TransactionLog> getTransactionsBetween(LocalDate start, LocalDate end) {
        return repository.findByTransactionDateBetween(start, end);
    }
}
