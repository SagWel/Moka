package com.moka.moka_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moka.moka_api.model.BudgetMonth;
import com.moka.moka_api.repository.BudgetMonthRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class BudgetMonthService {

    private final BudgetMonthRepository budgetMonthRepository;

    public List<BudgetMonth> getAllBudgetMonths() {
        return budgetMonthRepository.findAll();
    }

    public BudgetMonth creaBudgetMonth(BudgetMonth budgetMonth) {
        return budgetMonthRepository.save(budgetMonth);
    }

    public void deleteBudgetMonth(String id) {
        budgetMonthRepository.deleteById(id);
    }
}
