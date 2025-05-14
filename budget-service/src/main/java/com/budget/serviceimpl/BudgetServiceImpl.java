package com.budget.serviceimpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.budget.config.BudgetMapper;
import com.budget.dto.BudgetRequest;
import com.budget.dto.BudgetResponse;
import com.budget.entity.Budget;
import com.budget.exception.BudgetNotFoundException;
import com.budget.repository.BudgetRepository;
import com.budget.service.BudgetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

	private final BudgetRepository budgetRepository;
	private final BudgetMapper budgetMapper;

	@Override
    public BudgetResponse createBudget(BudgetRequest budgetRequest) {
        Budget budget = budgetMapper.toEntity(budgetRequest);
        Budget savedBudget = budgetRepository.save(budget);
        return budgetMapper.toResponse(savedBudget);
    }
	
	
	@Override
	public BudgetResponse getBudgetById(Long id) {
	    Budget budget = budgetRepository.findById(id)
	            .orElseThrow(() -> new BudgetNotFoundException("Budget not found with id: " + id));
	    
	    return budgetMapper.toResponse(budget); // ✅ using custom mapper
	}


	
	@Override
	public List<BudgetResponse> getAllBudgetsByUserId(Long userId) {
	    return budgetRepository.findByUserId(userId).stream()
	            .map(budgetMapper::toResponse)
	            .collect(Collectors.toList());
	}



	@Override
	public BudgetResponse updateBudget(Long id, BudgetRequest budgetRequest) {
	    Budget existingBudget = budgetRepository.findById(id)
	            .orElseThrow(() -> new BudgetNotFoundException("Budget not found with id: " + id));

	    // 🔁 Use custom mapper to update only specific fields safely
	    budgetMapper.updateBudgetFromDto(budgetRequest, existingBudget);

	    Budget updatedBudget = budgetRepository.save(existingBudget);
	    return budgetMapper.toResponse(updatedBudget);
	}

	@Override
	public void deleteBudget(Long id) {
	    Budget budget = budgetRepository.findById(id)
	            .orElseThrow(() -> new BudgetNotFoundException("Budget not found with id: " + id));
	    
	    budgetRepository.delete(budget);
	}

	//If returning 0 is not ideal for your use case (e.g. budget must exist), you could do:
	@Override
	public BigDecimal getBudgetAmountForUserAndCategory(Long userId, String category) {
	    return budgetRepository.findByUserIdAndCategory(userId, category)
	            .stream()
	            .findFirst()
	            .map(Budget::getAmount)
	            .orElseThrow(() -> new BudgetNotFoundException(
	                "No budget found for userId: " + userId + " and category: " + category
	            ));
	}

}
