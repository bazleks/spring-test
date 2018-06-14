package com.bazleks.spring.timewatch.dto;

import java.time.Duration;
import java.time.LocalDateTime;


public class NotificationDto
{
	private String id;
	private String name;
	private LocalDateTime time;
	private Duration duration;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDateTime getTime()
	{
		return time;
	}

	public void setTime(LocalDateTime time)
	{
		this.time = time;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Duration getDuration()
	{
		return duration;
	}

	public void setDuration(Duration duration)
	{
		this.duration = duration;
	}
}
