//package org.example.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.model.EmailDetails;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.util.Objects;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//    private final JavaMailSender javaMailSender;
//
//    public void sendSimpleMail(EmailDetails details){
//        try{
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(details.getRecipient());
//            mailMessage.setText(details.getMessageBody());
//            mailMessage.setSubject(details.getSubject());
//            javaMailSender.send(mailMessage);
//        }catch (Exception e){
//            throw new RuntimeException("error", e);
//        }
//    }
//
//    public void sendEmailWithAttachment(EmailDetails details) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper;
//
//        try {
//            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//            mimeMessageHelper.setTo(details.getRecipient());
//            mimeMessageHelper.setText(details.getMessageBody());
//            mimeMessageHelper.setSubject(details.getSubject());
//
//            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
//
//            mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
//
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            throw new RuntimeException("error", e);
//        }
//
//    }
//
//}
