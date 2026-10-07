package com.moka.moka_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "accounts")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    private String id;

    private String name;

    private Double initialBalance;

    private Double currentBalance;

    private Double cashReserve;

    private Boolean apiSyncEnabled;

    private Integer syncDayOfMonth;
}
