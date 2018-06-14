package com.bazleks.spring.timewatch.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.dto.UserDto;
import com.bazleks.spring.timewatch.facades.NotificationFacade;


@Controller
public class HomepageController
{
	private static final String HOMEPAGE_URL = "/homepage";

	@Autowired
	private NotificationFacade notificationFacade;

	@ModelAttribute("notification")
	public NotificationDto createNotification()
	{
		return new NotificationDto();
	}

	@ModelAttribute("notifications")
	public Collection<NotificationDto> populateNotifications()
	{
		return notificationFacade.recentlyCreatedNotifications();
	}

	@ModelAttribute("user")
	public UserDto populateUser()
	{
		UserDto user = new UserDto();
		user.setName("Aleks");

		return user;
	}

	@RequestMapping(method = GET,
			value = HOMEPAGE_URL)
	public String homepage()
	{
		return "homepage";
	}
}
