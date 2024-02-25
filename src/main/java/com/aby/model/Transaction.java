package com.aby.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    @DBRef
    private Account from;

    @DBRef
    private Account to;

    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private TransactionStatus status;

    // Getters and setters
}
