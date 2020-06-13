package com.talissonmelo.projectevent.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.talissonmelo.projectevent.services.DBService;
import com.talissonmelo.projectevent.services.EmailService;
import com.talissonmelo.projectevent.services.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instantiateTestDataBase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}