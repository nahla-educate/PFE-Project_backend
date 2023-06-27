package com.myProject.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.demo.model.User;
import com.myProject.demo.repository.UserRepository;


@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/profile")
public class ProfileController {


  @Autowired
  Environment environment;
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public ResponseEntity<List<String>> getCurrentActiveProfiles() {
    return ResponseEntity.ok(Arrays.asList(environment.getActiveProfiles()));
  }
  
  @PutMapping("/updatePhoto/{userId}")
  public ResponseEntity<User> updatePhoto(@RequestParam("file") MultipartFile file, @PathVariable Long userId){
		User user = userRepository.getOne(userId);
		try {
			user.setImageUrl(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	     User savedUser =userRepository.save(user); 
      return ResponseEntity.ok(savedUser);
  }

}

