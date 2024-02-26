package com.aby.service;

import com.aby.model.Transaction;
import com.aby.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction initiateMoneyTransfer(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistoryForAccount(String accountId) {
        try {
            return transactionRepository.findByFromIdOrToIdOrderByTransactionDateDesc(accountId, accountId);

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}