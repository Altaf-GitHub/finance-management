package com.notification.config;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.notification.dto.NotificationRequest;
import com.notification.dto.NotificationResponse;
import com.notification.entity.Notification;

@Component
public class NotificationMapper {
	
	 // Map from Request DTO to Entity
    public Notification toEntity(NotificationRequest request) {
        if (request == null) return null;

        Notification notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setType(request.getType());
        notification.setMessage(request.getMessage());
        notification.setCategory(request.getCategory());
        notification.setBudgetAmount(request.getBudgetAmount());
        notification.setExpenseAmount(request.getExpenseAmount());
        notification.setExpenseDescription(request.getExpenseDescription());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        return notification;
    }

    // Map from Entity to Response DTO
    public NotificationResponse  toResponse(Notification  notification ) {
        if (notification == null) return null;

        NotificationResponse  notificationResponse  = new NotificationResponse ();
        notificationResponse.setId(notificationResponse.getId());
        notificationResponse.setUserId(notification.getUserId());
        notificationResponse.setType(notification.getType());
        notificationResponse.setMessage(notification.getMessage());
        notificationResponse.setCategory(notification.getCategory());
        notificationResponse.setBudgetAmount(notification.getBudgetAmount());
        notificationResponse.setExpenseAmount(notification.getExpenseAmount());
        notificationResponse.setExpenseDescription(notification.getExpenseDescription());
        notificationResponse.setCreatedAt(notification.getCreatedAt());
        notificationResponse.setRead(notification.isRead());
        return notificationResponse;
    }

}
