package com.bazleks.spring.timewatch.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.entities.Notification;
import com.bazleks.spring.timewatch.generators.NotificationIdGenerator;
import com.bazleks.spring.timewatch.repositories.NotificationRepository;
import com.bazleks.spring.timewatch.services.NotificationService;


@Service
public class NotificationServiceImpl implements NotificationService
{
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private NotificationIdGenerator notificationIdGenerator;

	@Override
	public Notification createNotification(NotificationDto notificationDto)
	{
		Notification notification = new Notification();
		notification.setId(notificationIdGenerator.generateNewId());
		notification.setTitle(notificationDto.getName());
		notification.setDateTime(notificationDto.getTime());

		return notificationRepository.save(notification);
	}

	@Override
	public List<Notification> recentlyCreatedNotifications()
	{
		List<Notification> sortedNotifications = new ArrayList<>();
		notificationRepository.findAll().forEach(sortedNotifications::add);
		sortedNotifications.sort(Comparator.comparing(Notification::getDateTime));
		return sortedNotifications;
	}
}
