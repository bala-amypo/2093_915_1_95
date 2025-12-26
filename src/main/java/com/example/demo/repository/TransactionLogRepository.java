package com.example.demo.repository;

import com.example.demo.model.TransactionLog;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLogRepository {

    TransactionLog save(TransactionLog transactionLog);

    List<TransactionLog> findAll();

    List<TransactionLog> findByTransactionDateBetween(LocalDate startDate, LocalDate endDate);
}
