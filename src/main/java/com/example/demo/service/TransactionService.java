package com.example.demo.service;

import com.example.demo.model.TransactionLog;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    TransactionLog addTransaction(TransactionLog log);

    List<TransactionLog> getAllTransactions();

    List<TransactionLog> getTransactionsBetween(LocalDate start, LocalDate end);
}
