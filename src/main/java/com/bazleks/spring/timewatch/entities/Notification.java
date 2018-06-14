package com.bazleks.spring.timewatch.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "entity")
public class Notification
{
	@Id
	@Column(name = "id")
	//todo: auto generated
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "date")
	private LocalDateTime dateTime;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public LocalDateTime getDateTime()
	{
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime)
	{
		this.dateTime = dateTime;
	}
}
