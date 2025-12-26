package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import java.util.List;
import java.time.LocalDate;

public interface TransactionService {

    TransactionLog addTransaction(Long userId, TransactionLog transactionLog);

    List<TransactionLog> getAllTransactions();

    List<TransactionLog> getTransactionsBetween(LocalDate start, LocalDate end);
}
