package com.aby.repo;

import com.aby.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Long> {
    List<Transaction> findByFromIdOrToId(String fromId, String toId);

    List<Transaction> findByFromIdOrToIdOrderByTransactionDateDesc(String fromId, String toId);
}
