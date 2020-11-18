package com.av4.playPuzzel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailNotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(String email) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("abhionly009@gmail.com");
		mail.setSubject("This is just checking email");
		mail.setText("Hi this is link verification for your mail ");
		
		javaMailSender.send(mail);
	}
	
}
