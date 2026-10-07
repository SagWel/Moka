package com.moka.moka_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.moka_api.model.BudgetMonth;
import com.moka.moka_api.service.BudgetMonthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/budgetMonths")

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BudgetMonthController {

    private final BudgetMonthService budgetMonthService;

    @GetMapping
    public ResponseEntity<List<BudgetMonth>> getAllBudgetMonths() {
        return ResponseEntity.ok(budgetMonthService.getAllBudgetMonths());
    }

    @PostMapping
    public ResponseEntity<BudgetMonth> createBudgetMonth(@RequestBody BudgetMonth budgetMonth) {
        BudgetMonth createBugetMonth = budgetMonthService.creaBudgetMonth(budgetMonth);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBugetMonth);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBudgetMonth(@PathVariable String id) {
        budgetMonthService.deleteBudgetMonth(id);
        return ResponseEntity.noContent().build();
    }
}
