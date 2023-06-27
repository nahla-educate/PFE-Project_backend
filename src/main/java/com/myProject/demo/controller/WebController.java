package com.myProject.demo.controller;



import java.time.Instant;

import org.apache.http.auth.AuthScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.myProject.demo.dto.PostDto;
import com.myProject.demo.model.Hello;
import com.myProject.demo.model.Post;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.UserRepository;
import com.myProject.demo.service.AuthService;



@Controller
public class WebController {
   
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private AuthService authService;

  private User user;
  


  @MessageMapping("/hello")
 @SendTo("/topic/hi")
public Hello greeting (@RequestBody Hello hello) throws Exception {
System.out.println("****************");
System.out.println(hello.getMessage());
System.out.println(hello.getEmail());

   return new Hello(hello.getMessage(), hello.getEmail());
   
 }
 


  
  
}
