package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository transactionRepo;
    private final UserRepository userRepository;

    public TransactionServiceImpl(TransactionLogRepository repo, UserRepository userRepo) {
        this.transactionRepo = repo;
        this.userRepository = userRepo;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepository.findById(userId).orElseThrow();
        log.validate();
        return transactionRepo.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return transactionRepo.findByUser(user);
    }
}
