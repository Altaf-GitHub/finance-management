package com.expense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByUserId(Long userId);

	List<Expense> findByUserIdAndCategory(Long userId, String category);

	List<Expense> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
	@Query("SELECT e.userId, e.category, SUM(e.amount) as totalExpenses " +
	           "FROM Expense e " +
	           "WHERE e.date BETWEEN :startDate AND :endDate " +
	           "GROUP BY e.userId, e.category")
	    List<Object[]> findExpensesGroupedByUserAndCategory(
	            @Param("startDate") LocalDate startDate,
	            @Param("endDate") LocalDate endDate);
}
