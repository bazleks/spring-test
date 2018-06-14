package com.bazleks.spring.timewatch.facades;

import java.util.Collection;

import com.bazleks.spring.timewatch.dto.NotificationDto;


public interface NotificationFacade
{
	Collection<NotificationDto> recentlyCreatedNotifications();

	void createNotification(NotificationDto notificationDto);
}
