package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLogRepository {
    TransactionLog save(TransactionLog log);
    List<TransactionLog> findByUser(User user);
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user, LocalDate start, LocalDate end);
}
