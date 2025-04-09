package com.budget.service;



import java.math.BigDecimal;
import java.util.List;

import com.budget.dto.BudgetRequest;
import com.budget.dto.BudgetResponse;

public interface BudgetService {
 BudgetResponse createBudget(BudgetRequest budgetRequest);
 BudgetResponse getBudgetById(Long id);
 List<BudgetResponse> getAllBudgetsByUserId(Long userId);
 BudgetResponse updateBudget(Long id, BudgetRequest budgetRequest);
 void deleteBudget(Long id);
 BigDecimal getBudgetAmountForUserAndCategory(Long userId, String category);
}
