package com.moka.moka_api.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.moka.moka_api.model.enums.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "transactions")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    private String id;

    private String accountId;

    private String categoryId;

    private String label;

    private String description;

    private Double amount;

    private LocalDate date;

    private TransactionStatus status;

    private Boolean isRecurring;
}
