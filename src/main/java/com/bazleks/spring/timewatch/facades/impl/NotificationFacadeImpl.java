package com.bazleks.spring.timewatch.facades.impl;

import static java.time.LocalDateTime.now;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.entities.Notification;
import com.bazleks.spring.timewatch.facades.NotificationFacade;
import com.bazleks.spring.timewatch.services.NotificationService;


@Service
public class NotificationFacadeImpl implements NotificationFacade
{
	@Autowired
	private NotificationService notificationService;

	/*
	public NotificationFacadeImpl(@Autowired NotificationIdGenerator notificationIdGenerator)
	{
		this.notificationIdGenerator = notificationIdGenerator;
		notifications = new ArrayList<>();
		//@formatter:off
		notifications.addAll(asList(
				createNotification("Smoking Stopped", of(2018, Month.JUNE, 10, 18, 0)),
				createNotification("Template Is Ready", of(2018, Month.JUNE, 13, 20, 31))));
		//@formatter:on
	}*/

	@Override
	public Collection<NotificationDto> recentlyCreatedNotifications()
	{
		//@formatter:off
		return notificationService.recentlyCreatedNotifications().stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
		//@formatter:on
	}

	private NotificationDto convertToDto(Notification notification)
	{
		return createNotification(notification.getId(), notification.getTitle(), notification.getDateTime());
	}

	@Override
	public void createNotification(NotificationDto notificationDto)
	{
		notificationService.createNotification(notificationDto);
	}

	private NotificationDto createNotification(String id, String title, LocalDateTime when)
	{
		NotificationDto notificationDto = new NotificationDto();
		notificationDto.setName(title);
		notificationDto.setTime(when);
		notificationDto.setDuration(Duration.between(when, now()));
		notificationDto.setId(id);
		return notificationDto;
	}
}
