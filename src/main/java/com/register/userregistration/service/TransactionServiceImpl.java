package com.register.userregistration.service;

import com.register.userregistration.DAO.TransactionDAO;
import com.register.userregistration.DAO.UserDAO;
import com.register.userregistration.model.Transaction;
import com.register.userregistration.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;
    private UserDAO userDAO;
    @Override
    public List<Transaction> getUserTransactions(Long userId, int page, int size, LocalDate filterDate, String searchText) {
        User user = userDAO.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return transactionDAO.findTransactionsByUser(user, page, size, filterDate, searchText);
    }


    @Override
    public List<Transaction> getOtherUserTransactions(Long requesterId, Long targetUserId, int page, int size, LocalDate filterDate, String searchText) {
        User requester = userDAO.findById(requesterId);
        User targetUser = userDAO.findById(targetUserId);
        if (requester == null || targetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        List<Transaction> transactions = transactionDAO.findTransactionsByUser(targetUser, page, size, filterDate, searchText);
        // Only show amount if transaction belongs to requester
        for (Transaction tx : transactions) {
            if (!tx.getUserId().equals(requesterId)) {
                tx.setAmount((Double) null);
            }
        }
        return transactions;
    }

    @Override
    public Transaction getTransactionDetails(Long requesterId, Long transactionId) {
        User requester = userDAO.findById(requesterId);
        if (requester == null) {
            throw new IllegalArgumentException("User not found");
        }
        Transaction transaction = transactionDAO.findById(transactionId);
        if (transaction == null || !transaction.getUserId().equals(requesterId)) {
            throw new IllegalArgumentException("Transaction not found or access denied");
        }
        return transaction;
    }


}





