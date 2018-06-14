package com.bazleks.spring.timewatch.generators.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bazleks.spring.timewatch.generators.NotificationIdGenerator;


@Service
public class NotificationIdGeneratorRuntime implements NotificationIdGenerator
{
	public static final int ID_LENGTH = 10;
	private List<String> generatedIds = new ArrayList<>();

	@Override
	public String generateNewId()
	{
		String randomlyGeneratedId;
		do
		{
			randomlyGeneratedId = generateRandomString();
		}
		while (generatedIds.contains(randomlyGeneratedId));
		generatedIds.add(randomlyGeneratedId);
		return randomlyGeneratedId;
	}

	private String generateRandomString()
	{
		char[] array = new char[ID_LENGTH];
		for (int i = 0; i < ID_LENGTH; i++)
		{
			array[i] = (char) (Math.random() * 27.0 + 64);
		}
		return String.valueOf(array);
	}
}
