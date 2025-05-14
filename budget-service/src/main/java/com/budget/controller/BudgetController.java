package com.budget.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.budget.dto.BudgetRequest;
import com.budget.dto.BudgetResponse;
import com.budget.service.BudgetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/budgets")
@RequiredArgsConstructor
@Tag(name = "Budget Management", description = "APIs for managing budgets")
public class BudgetController {

	private final BudgetService budgetService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BudgetResponse createBudget(@RequestBody BudgetRequest budgetRequest) {
		return budgetService.createBudget(budgetRequest);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get budget by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Budget found"),
            @ApiResponse(responseCode = "404", description = "Budget not found")
    })

	public BudgetResponse getBudgetById(@PathVariable Long id) {
		return budgetService.getBudgetById(id);
	}

	@GetMapping("/user/{userId}")
	@Operation(summary = "Get budget by user ID and category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Budget found"),
            @ApiResponse(responseCode = "404", description = "Budget not found")
    })
	public List<BudgetResponse> getAllBudgetsByUserId(@PathVariable Long userId) {
		return budgetService.getAllBudgetsByUserId(userId);
	}

	@PutMapping("/{id}")
	public BudgetResponse updateBudget(@PathVariable Long id, @RequestBody BudgetRequest budgetRequest) {
		return budgetService.updateBudget(id, budgetRequest);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBudget(@PathVariable Long id) {
	    budgetService.deleteBudget(id);
	    return ResponseEntity.ok("Budget deleted successfully");
	}
	
	 @GetMapping("/user/{userId}/category/{category}")
	    public BigDecimal getBudgetAmountForUserAndCategory(
	            @PathVariable Long userId,
	            @PathVariable String category) {
	        return budgetService.getBudgetAmountForUserAndCategory(userId, category);
	 }
}
