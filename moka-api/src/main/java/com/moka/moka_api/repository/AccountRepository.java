package com.moka.moka_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByUserId(String userId);
}
