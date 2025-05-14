package com.expense.config;

import org.springframework.stereotype.Component;

import com.expense.dto.ExpenseRequest;
import com.expense.dto.ExpenseResponse;
import com.expense.entity.Expense;

@Component
public class ExpenseMapper {

    public Expense toEntity(ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setUserId(request.getUserId());
        expense.setCategory(request.getCategory());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());
        return expense;
    }

    public ExpenseResponse toResponse(Expense expense) {
        ExpenseResponse response = new ExpenseResponse();
        response.setId(expense.getId());
        response.setUserId(expense.getUserId());
        response.setCategory(expense.getCategory());
        response.setAmount(expense.getAmount());
        response.setDescription(expense.getDescription());
        response.setDate(expense.getDate());
        return response;
    }

    public void updateExpenseFromDto(ExpenseRequest dto, Expense entity) {
        if (dto == null || entity == null) return;

        if (dto.getCategory() != null) {
            entity.setCategory(dto.getCategory());
        }
        if (dto.getAmount() != null) {
            entity.setAmount(dto.getAmount());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getDate() != null) {
            entity.setDate(dto.getDate());
        }
    }
}
