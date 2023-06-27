package com.myProject.demo.controller;

import javax.validation.ValidationException;

import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.demo.model.EmailConfig;
import com.myProject.demo.model.EmailModel;

@RestController
@RequestMapping("/recp")
public class EmailModelController {
  
  
  private EmailConfig emailConfig;
  
  
  public EmailModelController(EmailConfig emailConfig) {
    this.emailConfig = emailConfig;
  }




  @PostMapping
  public void sendEmail(@RequestBody EmailModel emailModel, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      throw new ValidationException("email is not valid");
    }
    
    //creer un mail sender
    
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(this.emailConfig.getHost());
    mailSender.setPort(this.emailConfig.getPort());
    mailSender.setUsername(this.emailConfig.getUsername());
    mailSender.setPassword(this.emailConfig.getPassword());

    //creer une instance de l email
   SimpleMailMessage emailMsg = new SimpleMailMessage();
   emailMsg.setFrom(emailModel.getEmail());
   emailMsg.setTo("twe@contact.com");
  emailMsg.setSubject("new Email from "+ emailModel.getName());
  emailMsg.setText(emailModel.getEmailModel());
  
  //envoie mail 
  
  mailSender.send(emailMsg);
    
    
    
  }
}
