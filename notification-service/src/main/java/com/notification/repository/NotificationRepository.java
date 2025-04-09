package com.notification.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByUserId(Long userId);

	List<Notification> findByUserIdAndReadFalse(Long userId);
}
