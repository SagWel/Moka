package com.moka.moka_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}
