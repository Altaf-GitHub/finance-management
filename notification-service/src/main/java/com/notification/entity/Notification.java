package com.notification.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private String type; // BUDGET_EXCEEDED, etc.

	@Column(nullable = false)
	private String message;

	@Column(nullable = false)
	private String category;

	@Column(nullable = false)
	private BigDecimal budgetAmount;

	@Column(nullable = false)
	private BigDecimal expenseAmount;

	@Column(nullable = false)
	private String expenseDescription;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private boolean read;
}
