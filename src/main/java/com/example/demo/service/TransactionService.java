package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    TransactionLog addTransaction(Long userId, TransactionLog transactionLog);

    List<TransactionLog> getAllTransactions();

    List<TransactionLog> getTransactionsBetween(LocalDate startDate, LocalDate endDate);
}
