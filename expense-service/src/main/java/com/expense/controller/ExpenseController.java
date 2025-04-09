package com.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expense.dto.ExpenseRequest;
import com.expense.dto.ExpenseResponse;
import com.expense.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ExpenseResponse createExpense(@RequestBody ExpenseRequest expenseRequest) {
		return expenseService.createExpense(expenseRequest);
	}

	@GetMapping("/{id}")
	public ExpenseResponse getExpenseById(@PathVariable Long id) {
		return expenseService.getExpenseById(id);
	}

	@GetMapping("/user/{userId}")
	public List<ExpenseResponse> getAllExpensesByUserId(@PathVariable Long userId) {
		return expenseService.getAllExpensesByUserId(userId);
	}

	@GetMapping("/user/{userId}/category/{category}")
	public List<ExpenseResponse> getExpensesByUserIdAndCategory(@PathVariable Long userId,
			@PathVariable String category) {
		return expenseService.getExpensesByUserIdAndCategory(userId, category);
	}

	@PutMapping("/{id}")
	public ExpenseResponse updateExpense(@PathVariable Long id, @RequestBody ExpenseRequest expenseRequest) {
		return expenseService.updateExpense(id, expenseRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
	}
}
