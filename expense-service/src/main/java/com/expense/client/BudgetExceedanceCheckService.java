package com.expense.client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.expense.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BudgetExceedanceCheckService {

	private final ExpenseRepository expenseRepository;
	private final BudgetServiceClient budgetServiceClient;
	private final NotificationServiceClient notificationServiceClient;

	@Scheduled(cron = "0 0 12 * * ?") // Run daily at noon
	public void checkForBudgetExceedances() {
		log.info("Starting budget exceedance check...");

		// Get all expenses grouped by user and category for current month
		LocalDate startDate = LocalDate.now().withDayOfMonth(1);
		LocalDate endDate = LocalDate.now();

		List<Object[]> results = expenseRepository.findExpensesGroupedByUserAndCategory(startDate, endDate);

		results.forEach(result -> {
			Long userId = (Long) result[0];
			String category = (String) result[1];
			BigDecimal totalExpenses = (BigDecimal) result[2];

			// Get budget for this user and category
			BigDecimal budgetAmount = budgetServiceClient.getBudgetAmountForUserAndCategory(userId, category);

			if (budgetAmount != null && totalExpenses.compareTo(budgetAmount) > 0) {
				// Budget exceeded, send notification
				String message = String.format("Budget exceeded for category %s. Budget: %s, Expenses: %s", category,
						budgetAmount, totalExpenses);

				notificationServiceClient.createNotification(userId, "BUDGET_EXCEEDED", message, category, budgetAmount,
						totalExpenses, "Monthly expenses for " + category);

				log.info("Notification sent for user {}: {}", userId, message);
			}
		});

		log.info("Budget exceedance check completed.");
	}
}
