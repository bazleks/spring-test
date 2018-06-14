package com.bazleks.spring.timewatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bazleks.spring.timewatch.dto.NotificationDto;
import com.bazleks.spring.timewatch.facades.NotificationFacade;


@Controller
public class NotificationController
{
	@Autowired
	private NotificationFacade notificationFacade;

	@PostMapping("/createNotification")
	public String createNotification(@ModelAttribute("notification") NotificationDto notification, BindingResult bindingResult,
			Model model)
	{
		notificationFacade.createNotification(notification);
		return "redirect:/homepage";
	}
}
