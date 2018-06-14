package com.bazleks.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bazleks.spring.timewatch.controllers.converters.StringToPersonConverter;


@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addFormatters(FormatterRegistry registry)
	{
		registry.addConverter(new StringToPersonConverter());
	}
}