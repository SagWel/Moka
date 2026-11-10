package com.moka.moka_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByAccountId(String accountId);
}
