package com.expense.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseResponse {
    private Long id;
    private Long userId;
    private String category;
    private BigDecimal amount;
    private String description;
    private LocalDate date;
}
