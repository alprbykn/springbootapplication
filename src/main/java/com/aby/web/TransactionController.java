package com.aby.web;

import com.aby.model.Transaction;
import com.aby.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> initiateMoneyTransfer(@RequestBody Transaction transaction) {
        Transaction initiatedTransaction = transactionService.initiateMoneyTransfer(transaction);
        return new ResponseEntity<>(initiatedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionHistoryForAccount(@PathVariable String accountId) {
        List<Transaction> transactions = transactionService.getTransactionHistoryForAccount(accountId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}