package com.bazleks.spring.timewatch.controllers.converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;


/**
 * Converter for converting {@link String} passed from ui into {@link LocalDateTime}
 * Data format is {@link DateTimeFormatter.ISO_DATE}
 */
public class StringToPersonConverter implements Converter<String, LocalDateTime>
{
	@Override
	public LocalDateTime convert(String source)
	{
		return LocalDate.parse(source, DateTimeFormatter.ISO_DATE).atTime(LocalTime.now());
	}
}
