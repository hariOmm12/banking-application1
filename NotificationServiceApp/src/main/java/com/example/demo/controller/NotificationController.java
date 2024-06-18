package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.NotificationDTO;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

	
	@PostMapping 
	public ResponseEntity<Void> sendNotification(@RequestBody NotificationDTO notificationDTO) {
	  notificationService.sendNotification(notificationDTO); return
	  ResponseEntity.status(HttpStatus.OK).build(); 
	  }
	 
    
	/*
	 * @PostMapping("/send") public void sendNotification(@RequestParam String
	 * to, @RequestParam String subject, @RequestParam String text) throws
	 * MessagingException { notificationService.sendNotification(to, subject, text);
	 * }
	 */
}