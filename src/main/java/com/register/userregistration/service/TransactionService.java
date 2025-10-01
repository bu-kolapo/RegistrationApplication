package com.register.userregistration.service;

import com.register.userregistration.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    List<Transaction> getUserTransactions(Long userId, int page, int size, LocalDate filterDate, String searchText);
    List<Transaction> getOtherUserTransactions(Long requesterId, Long targetUserId, int page, int size, LocalDate filterDate, String searchText);
    Transaction getTransactionDetails(Long requesterId, Long transactionId);
}
