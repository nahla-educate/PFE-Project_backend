package com.myProject.demo.controller;

import java.util.Arrays;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.demo.exception.ResourceNotFoundException;
import com.myProject.demo.model.Candidate;
import com.myProject.demo.repository.CandidateRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CandidateController {
  
  
  @Autowired
  private CandidateRepository candidateRepository ;
  
   
  
  //get tous les candidates 
  
  @GetMapping("/candidates")
  public List<Candidate> getAllCandidates(){
    
    return candidateRepository.findAll();
  }
  
  

  
  
  
  //get Candidate byID
  
  @GetMapping("/candidates/{id}")
  public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id){
    Candidate candidate = candidateRepository.findById(id)
  .orElseThrow(() -> new ResourceNotFoundException("candidate not exist with id :"+ id));
    return ResponseEntity.ok(candidate);
  }

  
  
  
  //creer candidate rest api
  @PostMapping("/candidates")
  public Candidate createCandidate(@RequestBody Candidate candidate) {
    return candidateRepository.save(candidate);
  }
  
  
  
  //modifier
  @PutMapping("/candidates/{id}")
  public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidateDetails){
    
   Candidate candidate = candidateRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Candidate not exist with id :"+ id));
   
   candidate.setNom(candidateDetails.getNom());
   candidate.setPrenom(candidateDetails.getPrenom());
   candidate.setEmail(candidateDetails.getEmailId());
   candidate.setTelephone(candidateDetails.getTelephone());
   candidate.setPoste(candidateDetails.getPoste());
   candidate.setStage(candidateDetails.getStage());

   Candidate updatedCandidate = candidateRepository.save(candidate);
   return ResponseEntity.ok(updatedCandidate);  
  }
  
  
  
  
  //supprimer une candidate
  @DeleteMapping("/candidates/{id}")
public ResponseEntity<Map<String, Boolean>> deleteCandidate(@PathVariable Long id){
    Candidate candidate = candidateRepository.findById(id)
        .orElseThrow(() ->
    new ResourceNotFoundException("Candidate not exist with id :" + id));
    
    candidateRepository.delete(candidate);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
    


  @Autowired
  Environment environment;

  @GetMapping("/current")
  public ResponseEntity<List<String>> getCurrentActiveProfiles() {
    return ResponseEntity.ok(Arrays.asList(environment.getActiveProfiles()));
  }


  
}











