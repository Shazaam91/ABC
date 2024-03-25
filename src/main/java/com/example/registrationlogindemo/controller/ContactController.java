package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.ContactMessage;
import com.example.registrationlogindemo.service.ContactMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private final ContactMessageService messageService;

    public ContactController(ContactMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactMessage message) {
        try {
            messageService.saveContactMessage(message);
            return ResponseEntity.ok().body("{\"success\": true}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
