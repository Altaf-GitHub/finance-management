package com.budget.config;

import org.springframework.stereotype.Component;

import com.budget.dto.BudgetRequest;
import com.budget.dto.BudgetResponse;
import com.budget.entity.Budget;

@Component
public class BudgetMapper {
	// Convert DTO -> Entity
    public Budget toEntity(BudgetRequest request) {
        Budget budget = new Budget();
        budget.setUserId(request.getUserId());
        budget.setCategory(request.getCategory());
        budget.setAmount(request.getAmount());
        budget.setPeriod(request.getPeriod());
        return budget;
    }

    // Convert Entity -> DTO
    public BudgetResponse toResponse(Budget budget) {
        BudgetResponse response = new BudgetResponse();
        response.setId(budget.getId());
        response.setUserId(budget.getUserId());
        response.setCategory(budget.getCategory());
        response.setAmount(budget.getAmount());
        response.setPeriod(budget.getPeriod());
        return response;
    }
    
    public void updateBudgetFromDto(BudgetRequest dto, Budget entity) {
        if (dto == null || entity == null) return;

        if (dto.getCategory() != null) {
            entity.setCategory(dto.getCategory());
        }
        if (dto.getAmount() != null) {
            entity.setAmount(dto.getAmount());
        }
        if (dto.getPeriod() != null) {
            entity.setPeriod(dto.getPeriod());
        }

        
    
}
}



