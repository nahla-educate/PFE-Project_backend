package com.myProject.demo.service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myProject.demo.dto.LoginRequest;
import com.myProject.demo.dto.PostDto;
import com.myProject.demo.dto.RegisterRequest;
import com.myProject.demo.exception.RecruteurNotFoundException;
import com.myProject.demo.exception.ResourceNotFoundException;
import com.myProject.demo.model.Candidate;
import com.myProject.demo.model.ERole;
import com.myProject.demo.model.ParcoursUniv;
import com.myProject.demo.model.Post;
import com.myProject.demo.model.Recruteur;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.CandidateRepository;
import com.myProject.demo.repository.UserRepository;
import com.myProject.demo.security.JwtProvider;


@Service
@CrossOrigin(origins ="http://localhost:4200")
public class AuthService {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private EmailService emailService;
  @Autowired
  private VerificationTokenService verificationTokenService;

  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private  AuthenticationManager authenticationManager;
  
  @Autowired
  private JwtProvider jwtProvider;
  
  @Autowired
  private CandidateRepository candRepo;
  
  @Autowired
  AuthService authService;
  
  
  @Autowired
  private UserRepository userRepo;



  private User user;
  






  
  
  
  public void signup(RegisterRequest registerRequest) {
    User user = new User();
    
    user.setUsername(registerRequest.getUsername());
    user.setEmail(registerRequest.getEmail());
    user.setEtat(registerRequest.getEtat());
    user.setRole(registerRequest.getRole());

    user.setPassword(encodePassword(registerRequest.getPassword()));    
    user.setCreated(Instant.now());
    user.setRole(registerRequest.getRole());
    user.setAdresse(registerRequest.getAdresse());
    user.setPoste(registerRequest.getPoste());
user.setExperience(registerRequest.getExperience());  
//user.setEnabled(true);
//disabled new user before activation
user.setEnabled(false);

//userRepository.save(user);
Optional<User> saved = Optional.of( userRepository.save(user));
 
// create and save verification token
 saved.ifPresent( u -> {
try {
String token = UUID.randomUUID().toString();
verificationTokenService.save(saved.get(), token);

//send verification email
emailService.sendHtmlMail(u);

}catch(Exception e) {
e.printStackTrace();
}
 });
 
  saved.get();

}

   


  private String encodePassword(String password) {
    return passwordEncoder.encode(password);
    
  }
  
//  public AuthenticationResponse login(LoginRequest loginRequest) {
//    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
//            loginRequest.getPassword()));
//    SecurityContextHolder.getContext().setAuthentication(authenticate);
//    String authenticationToken = jwtProvider.generateToken(authenticate);
//    return new AuthenticationResponse(authenticationToken, loginRequest.getEmail());
//}
//
//  
  
  
 @Autowired
  Environment environement;
 
 public AuthenticationResponse login(LoginRequest loginRequest) {
   System.out.println("******************************0");
   System.out.println(loginRequest);
    Optional<User> user ;
    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authenticate);
    String authenticationToken = jwtProvider.generateToken(authenticate);
  user = userRepo.findByEmail(authenticate.getName());
  System.out.println(authenticate.getName());
    return new AuthenticationResponse(authenticationToken,user.get());
}
  
  

 public Optional<org.springframework.security.core.userdetails.User> getCurrentUser(){
   
  org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)SecurityContextHolder
      .getContext().getAuthentication().getPrincipal();
      System.out.println(principal);
   return Optional.of(principal);   
 }
 
  
  
  public User currentUserName(User user) {
    return this.user; // Here you get the current user.
  }
  
  
     
   public List<User> findAllUsers(){
    return userRepository.findAll();
    }
//   
//   
   public User findUserById(Long id) {
     return userRepository.findUserById(id)  
         .orElseThrow(() -> new RecruteurNotFoundException("Récruteur by id"+ id + "was not found"));
     }
//   
   
   public User findUserByEmail(String email) {
     return userRepository.findUserByEmail(email) ;
        
     }
//   
   
   
   
   public List<Candidate> IsCand() {
          return candRepo.findAll();
   }

}

//  public User updatePassword(Long id, String password) {
//    return userRepository.findUserById(id)  
//        .orElseThrow(() -> new ResourceNotFoundException("User by id"+ id + "was not found"));
//    }
//  }
//   





  
//  public String login(LoginRequest loginRequest)
//  {
//    Authentication authenticate = authenticationManager
//       .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//    SecurityContextHolder.getContext().setAuthentication(authenticate);
//    return jwtProvider.generateToken(authenticate);
//  }
//  
  
  
  
  
//  public String login(LoginRequest loginRequest) {
//   Authentication authenticate =  authenticationManager.
//       authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//   SecurityContextHolder.getContext().setAuthentication(authenticate);
// return  jwtProvider.generateToken(authenticate);
//  }
  
  
//  public Optional<org.springframework.security.core.userdetails.User>  getCurrentUser() {
//  org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
//      .getContext().getAuthentication().getPrincipal();
//  
//  return Optional.of(principal);
//  }
//  
  
  
//  public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
//    org.springframework.security.core.userdetails.User principal =
//        (org.springframework.security.core.userdetails.User) SecurityContextHolder.
//            getContext().getAuthentication().getPrincipal();
//    return Optional.of(principal);
//}
//  
  
  
  
  
  
  
  
  
  
  