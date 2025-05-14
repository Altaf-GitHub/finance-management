package com.expense.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.expense.config.ExpenseMapper;
import com.expense.dto.ExpenseRequest;
import com.expense.dto.ExpenseResponse;
import com.expense.entity.Expense;
import com.expense.exception.ExpenseNotFoundException;
import com.expense.repository.ExpenseRepository;
import com.expense.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository;
	//private final ModelMapper modelMapper;
	private final ExpenseMapper expenseMapper;

	/*
	 * @Override public ExpenseResponse createExpense(ExpenseRequest expenseRequest)
	 * { modelMapper.typeMap(ExpenseRequest.class, Expense.class)
	 * .addMappings(mapper -> mapper.skip(Expense::setId)); Expense expense =
	 * modelMapper.map(expenseRequest, Expense.class); Expense savedExpense =
	 * expenseRepository.save(expense); return modelMapper.map(savedExpense,
	 * ExpenseResponse.class); }
	 */
	@Override
	public ExpenseResponse createExpense(ExpenseRequest request) {
	    Expense expense = expenseMapper.toEntity(request);
	    Expense savedExpense = expenseRepository.save(expense);
	    return expenseMapper.toResponse(savedExpense);
	}


	/*
	 * @Override public ExpenseResponse getExpenseById(Long id) { Expense expense =
	 * expenseRepository.findById(id) .orElseThrow(() -> new
	 * ExpenseNotFoundException("Expense not found with id: " + id)); return
	 * expenseMapper.map(expense, ExpenseResponse.class); }
	 */
	
	@Override
	public ExpenseResponse getExpenseById(Long id) {
	    Expense expense = expenseRepository.findById(id)
	            .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + id));
	    return expenseMapper.toResponse(expense);  // Using the custom mapper
	}

	/*
	 * @Override public List<ExpenseResponse> getAllExpensesByUserId(Long userId) {
	 * return expenseRepository.findByUserId(userId).stream() .map(expense ->
	 * modelMapper.map(expense,
	 * ExpenseResponse.class)).collect(Collectors.toList()); }
	 */
	
	@Override
	public List<ExpenseResponse> getAllExpensesByUserId(Long userId) {
	    return expenseRepository.findByUserId(userId).stream()
	            .map(expenseMapper::toResponse)  // Using the custom mapper
	            .collect(Collectors.toList());
	}

	/*
	 * @Override public List<ExpenseResponse> getExpensesByUserIdAndCategory(Long
	 * userId, String category) { return
	 * expenseRepository.findByUserIdAndCategory(userId, category).stream()
	 * .map(expense -> modelMapper.map(expense,
	 * ExpenseResponse.class)).collect(Collectors.toList()); }
	 */
	
	@Override
	public List<ExpenseResponse> getExpensesByUserIdAndCategory(Long userId, String category) {
	    return expenseRepository.findByUserIdAndCategory(userId, category).stream()
	            .map(expenseMapper::toResponse)  // Using the custom mapper
	            .collect(Collectors.toList());
	}


	/*
	 * @Override public ExpenseResponse updateExpense(Long id, ExpenseRequest
	 * expenseRequest) { Expense existingExpense = expenseRepository.findById(id)
	 * .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: "
	 * + id));
	 * 
	 * modelMapper.map(expenseRequest, existingExpense); Expense updatedExpense =
	 * expenseRepository.save(existingExpense); return
	 * modelMapper.map(updatedExpense, ExpenseResponse.class); }
	 */
	
	@Override
	public ExpenseResponse updateExpense(Long id, ExpenseRequest expenseRequest) {
	    Expense existingExpense = expenseRepository.findById(id)
	            .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + id));

	    // Update the existing entity with the new values from expenseRequest
	    expenseMapper.updateExpenseFromDto(expenseRequest, existingExpense);

	    Expense updatedExpense = expenseRepository.save(existingExpense);
	    return expenseMapper.toResponse(updatedExpense);  // Using the custom mapper
	}

	/*
	 * @Override public void deleteExpense(Long id) { if
	 * (!expenseRepository.existsById(id)) { throw new
	 * ExpenseNotFoundException("Expense not found with id: " + id); }
	 * expenseRepository.deleteById(id); }
	 */
	
	@Override
	public void deleteExpense(Long id) {
	    if (!expenseRepository.existsById(id)) {
	        throw new ExpenseNotFoundException("Expense not found with id: " + id);
	    }
	    expenseRepository.deleteById(id);
	}

}
