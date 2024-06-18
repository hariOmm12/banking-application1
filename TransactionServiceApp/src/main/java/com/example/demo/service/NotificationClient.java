package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.NotificationRequest;

@Service
public class NotificationClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;

    public void sendNotification(String email, Double amount) {
        String notificationEndpoint = notificationServiceUrl + "/notifications/send";

        // Prepare request body (assuming JSON)
        NotificationRequest request = new NotificationRequest(email, "Transaction Notification", "A transaction of amount " + amount + " has been made from your account.");

        // Send POST request to Notification Service
        try {
            restTemplate.postForObject(notificationEndpoint, request, Void.class);
        } catch (Exception e) {
            // Handle exception (logging, error handling)
            e.printStackTrace();
            throw new RuntimeException("Failed to send notification to " + email);
        }
    }
}