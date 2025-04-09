package com.expense.client;

//BudgetServiceClient.java

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.math.BigDecimal;

@FeignClient(name = "budget-service", url = "${budget.service.url}") // Configure URL in application.yml
public interface BudgetServiceClient {

 @GetMapping("/api/v1/budgets/user/{userId}/category/{category}")
 BigDecimal getBudgetAmountForUserAndCategory(
     @PathVariable Long userId,
     @PathVariable String category
 );
}