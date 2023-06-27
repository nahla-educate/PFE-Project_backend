package com.myProject.demo.service;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.myProject.demo.model.User;
import com.myProject.demo.model.VerificationToken;
@Service
public class EmailService {
private final VerificationTokenService verificationTokenService;
private final TemplateEngine templateEngine;
private final JavaMailSender javaMailSender;



@Autowired
public EmailService(VerificationTokenService verificationTokenService, TemplateEngine templateEngine, JavaMailSender javaMailSender ) {
this.verificationTokenService = verificationTokenService;
this.templateEngine = templateEngine;
this.javaMailSender = javaMailSender;
}

public void sendHtmlMail(User user) throws MessagingException {
VerificationToken verificationToken = verificationTokenService.findByUser(user);
//check if the user has a token
if(verificationToken != null) {
String token = verificationToken.getToken();
Context context = new Context();
context.setVariable("title", "Vérifier votre adresse email");
context.setVariable("link", "http://localhost:8080/api/auth/activation?token="+token);
//create an html template and pass the variables to it
//verifie l partie hedhi

String body = templateEngine.process("verification", context);
//send the verification email

MimeMessage message = javaMailSender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message, true);
helper.setTo(user.getEmail());
helper.setSubject("Vérification d'adresse email");
helper.setText(body, true);
javaMailSender.send(message);
}
}

}