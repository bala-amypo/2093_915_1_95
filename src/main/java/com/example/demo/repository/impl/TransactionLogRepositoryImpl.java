package com.example.demo.repository.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TransactionLogRepositoryImpl implements TransactionLogRepository {
    private final Map<Long, TransactionLog> transactions = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public TransactionLog save(TransactionLog transactionLog) {
        if (transactionLog.getId() == null) {
            transactionLog.setId(idGenerator.getAndIncrement());
        }
        transactions.put(transactionLog.getId(), transactionLog);
        return transactionLog;
    }

    @Override
    public List<TransactionLog> findByUser(User user) {
        return transactions.values().stream()
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionLog> findByUserAndTransactionDateBetween(User user, LocalDate start, LocalDate end) {
        return transactions.values().stream()
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .filter(t -> !t.getTransactionDate().isBefore(start) && !t.getTransactionDate().isAfter(end))
                .collect(Collectors.toList());
    }
}