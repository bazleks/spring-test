package com.bazleks.spring.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.facades.NotificationFacade;


@RestController
public class WsNotificationController
{
	@Autowired
	private NotificationFacade notificationFacade;

	@GetMapping("/recentNotifications")
	public List<NotificationDto> recentNotifications()
	{
		return new ArrayList<>(notificationFacade.recentlyCreatedNotifications());
	}
}
