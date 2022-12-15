package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.EmailDetails;
import org.example.service.EmailService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PutMapping("/sendMail")
    public void sendMail(@RequestBody EmailDetails details) {
        emailService.sendSimpleMail(details);
    }

    @PutMapping("/sendEmailWithAttachment")
    public void sendEmailWithAttachment(@RequestBody EmailDetails details){
        emailService.sendEmailWithAttachment(details);
    }

}
