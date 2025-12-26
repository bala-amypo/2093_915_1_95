package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        log.setUser(user);
        log.validate();
        return repo.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return repo.findByUser(user);
    }

    @Override
    public List<TransactionLog> getTransactionsBetween(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException("Handled in repository");
    }
}
