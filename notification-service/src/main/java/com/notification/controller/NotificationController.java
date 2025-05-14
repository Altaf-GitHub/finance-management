package com.notification.controller;

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

import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;
import com.notification.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest) {
		return notificationService.createNotification(notificationRequest);
	}

	@GetMapping("/user/{userId}")
	public List<NotificationResponse> getAllNotificationsByUserId(@PathVariable Long userId) {
		return notificationService.getAllNotificationsByUserId(userId);
	}

	@GetMapping("/user/{userId}/unread")
	public List<NotificationResponse> getUnreadNotificationsByUserId(@PathVariable Long userId) {
		return notificationService.getUnreadNotificationsByUserId(userId);
	}

	@PutMapping("/{id}/mark-as-read")
	public NotificationResponse markAsRead(@PathVariable Long id) {
		return notificationService.markAsRead(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteNotification(@PathVariable Long id) {
		notificationService.deleteNotification(id);
	}
}
