package com.register.userregistration.controller;

import com.register.userregistration.model.Transaction;
import com.register.userregistration.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("user/transactions")
    public ResponseEntity<List<Transaction>> getUserTransactions(
            @RequestParam Long userId,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate filterDate,
            @RequestParam(required = false) String searchText) {
        List<Transaction> transactions = transactionService.getUserTransactions(userId, page, size, filterDate, searchText);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/users/{targetUserId}/transactions")
    public ResponseEntity<List<Transaction>> getOtherUserTransactions(
            @RequestParam Long requesterId,
            @PathVariable Long targetUserId,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate filterDate,
            @RequestParam(required = false) String searchText) {
        List<Transaction> transactions = transactionService.getOtherUserTransactions(requesterId, targetUserId, page, size, filterDate, searchText);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{transactionId}")
        public ResponseEntity<Transaction> getTransactionDetails(
                @RequestParam Long requesterId,
                @PathVariable Long transactionId) {
            Transaction transaction = transactionService.getTransactionDetails(requesterId, transactionId);
            return ResponseEntity.ok(transaction);
        }


}

