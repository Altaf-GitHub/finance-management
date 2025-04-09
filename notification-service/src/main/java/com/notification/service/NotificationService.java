package com.notification.service;

import java.util.List;
import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;

public interface NotificationService {
	NotificationResponse createNotification(NotificationRequest notificationRequest);

	List<NotificationResponse> getAllNotificationsByUserId(Long userId);

	List<NotificationResponse> getUnreadNotificationsByUserId(Long userId);

	NotificationResponse markAsRead(Long id);
}
