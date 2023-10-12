package com.enviro.assessment.grad001.lwandonodume.backend.services.Impl;

import com.enviro.assessment.grad001.lwandonodume.backend.models.SendEmail;
import com.enviro.assessment.grad001.lwandonodume.backend.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmail(SendEmail sendEmail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("etalentwithdrawal.notice@example.com");
        message.setTo(sendEmail.getTo());
        message.setSubject(sendEmail.getSubject());
        message.setText(sendEmail.getBody());
        mailSender.send(message);
    }
}
