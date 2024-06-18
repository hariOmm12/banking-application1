package com.example.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NotificationDTO;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

	
	  public void sendNotification(NotificationDTO notificationDTO) {
		  SimpleMailMessage message = new SimpleMailMessage();
		  message.setTo(notificationDTO.getEmail());
		  message.setSubject("Transaction Notification"); 
		  message.setText("A " +
			  notificationDTO.getType() + " of amount " + notificationDTO.getAmount() +
			  " has been made on your account."); 
		  javaMailSender.send(message); 
	  }
	 
    
	/*
	 * public void sendNotification(String to, String subject, String text) throws
	 * MessagingException { MimeMessage message =
	 * javaMailSender.createMimeMessage(); MimeMessageHelper helper = new
	 * MimeMessageHelper(message, true); helper.setTo(to);
	 * helper.setSubject(subject); helper.setText(text, true);
	 * javaMailSender.send(message); }
	 */
}
