package com.myProject.demo.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.apache.http.auth.AuthScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.demo.dto.ParcoursRequest;
import com.myProject.demo.dto.RegisterRequest;
import com.myProject.demo.exception.RecruteurNotFoundException;
import com.myProject.demo.model.ParcoursUniv;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.ParcoursUnivRepository;
import com.myProject.demo.service.AuthService;
import com.myProject.demo.service.ParcoursUnivService;

@RestController
@RequestMapping("/api/parcours")
@CrossOrigin("http://localhost:4200")
public class ParcoursUnivController {

  @Autowired
  ParcoursUnivRepository parcoursRepo;
  
@Autowired 
ParcoursUnivService parcoursService;


@Autowired
AuthService authService;




@PostMapping("/{email}")
public ParcoursUniv saveParcours(@PathVariable("email") String email, @RequestBody ParcoursUniv parcours) {
 User user = authService.findUserByEmail(email); 
 parcours.setUser(user);
 return  parcoursRepo.save(parcours);
}






@GetMapping
public List<ParcoursUniv> findAllParcours(){

 return  parcoursRepo.findAll();
}




  


  
}
