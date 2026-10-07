package com.moka.moka_api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "budget_months")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetMonth {
    @Id
    private String id;

    private Integer month;

    private Integer year;

    private Double targetIncome;

    private List<CategoryBudget> categoryBudgets;
}
