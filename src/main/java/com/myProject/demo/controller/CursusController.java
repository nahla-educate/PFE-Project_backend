package com.myProject.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.demo.dto.RegisterRequest;
import com.myProject.demo.exception.ResourceNotFoundException1;
import com.myProject.demo.model.Cursus;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.CursusRepository;
import com.myProject.demo.repository.UserRepository;


@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api/v2")
public class CursusController {

    @Autowired
    private CursusRepository cursusRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/cursus")
    public List< Cursus > getCursusByUser(@PathVariable(value = "userId") Long userId) {
        return cursusRepository.findByUserId(userId);
    }

    

    @PostMapping("/users/{userId}/cursus")
    public Cursus createCursus(@PathVariable(value = "userId") Long userId,
        @Valid @RequestBody Cursus cursus) throws ResourceNotFoundException1 {
        return userRepository.findUserById(userId).map(user -> {
            cursus.setUser(user);
            return cursusRepository.save(cursus);
        }).orElseThrow(() -> new ResourceNotFoundException1("cursus not found"));
    }
    
    
    
    
//    @PostMapping("/users/{userId}/cursus")
//    public User createCursus(@PathVariable(value = "userId") Long userId,
//       @Valid @RequestBody Cursus cursus) throws ResourceNotFoundException1 {
//               cursusRepository.save(cursus);
//            return userRepository.getOne(userId);
//        .orElseThrow(() -> new ResourceNotFoundException1("cursus not found"));
//
//    }
    
    
   
    @PutMapping("/users/{userId}/cursus/{cursusId}")
    public Cursus updateCursus(@PathVariable(value = "userId") Long userId,
        @PathVariable(value = "cursusId") Long cursusId, @Valid @RequestBody Cursus cursusRequest)
    throws ResourceNotFoundException1 {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException1("instructorId not found");
        }

        return cursusRepository.findById(cursusId).map(cursus -> {
          cursus.setDiplome(cursusRequest.getDiplome());
          cursus.setAnneeDiplome(cursusRequest.getAnneeDiplome());
          cursus.setUniversiteDiplome(cursusRequest.getUniversiteDiplome());

          return cursusRepository.save(cursus);
      }).orElseThrow(() -> new ResourceNotFoundException1("cursus id not found"));
  }
    
    
    @DeleteMapping("/users/{userId}/cursus/{cursusId}")
    public ResponseEntity<?> deleteCursus(@PathVariable(value = "userId") Long userId,
        @PathVariable(value = "cursusId") Long cursusId) throws ResourceNotFoundException1 {
        return cursusRepository.findByIdAndUserId(cursusId, userId).map(cursus -> {
            cursusRepository.delete(cursus);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException1(
            "cursus not found with cursusId " + cursusId + " and userId " + userId));
    }
}