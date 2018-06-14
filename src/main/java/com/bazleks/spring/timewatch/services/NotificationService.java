package com.bazleks.spring.timewatch.services;

import java.util.List;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.entities.Notification;


public interface NotificationService
{
	Notification createNotification(NotificationDto notificationDto);

	List<Notification> recentlyCreatedNotifications();
}
