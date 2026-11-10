package com.moka.moka_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.BudgetMonth;

public interface BudgetMonthRepository extends MongoRepository<BudgetMonth, String> {
    List<BudgetMonth> findByAccountIdAndMonthAndYear(String accountId, Integer month, Integer year);
}
