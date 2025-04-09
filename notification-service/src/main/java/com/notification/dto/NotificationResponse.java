package com.notification.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NotificationResponse {
	private Long id;
	private Long userId;
	private String type;
	private String message;
	private String category;
	private BigDecimal budgetAmount;
	private BigDecimal expenseAmount;
	private String expenseDescription;
	private LocalDateTime createdAt;
	private boolean read;
}
