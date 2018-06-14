package com.bazleks.spring.timewatch.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bazleks.spring.timewatch.entities.Notification;


public interface NotificationRepository extends CrudRepository<Notification, String>
{
}
