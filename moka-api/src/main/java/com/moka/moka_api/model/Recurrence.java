package com.moka.moka_api.model;

import com.moka.moka_api.model.enums.RecurrenceRate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recurrence {
    private RecurrenceRate recurrenceRate;

    private Integer end;
}
