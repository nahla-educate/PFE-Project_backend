package com.myProject.demo.service;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myProject.demo.exception.RecruteurNotFoundException;
import com.myProject.demo.model.Candidate;
import com.myProject.demo.model.Recruteur;
import com.myProject.demo.repository.CandidateRepository;
import com.myProject.demo.repository.RecruteurRepository;



@Service
public class RecruteurService {

  private final RecruteurRepository recruteurRepository ;

  @Autowired
  public RecruteurService(RecruteurRepository recruteurRepository) {
    this.recruteurRepository = recruteurRepository;
  }
  
  
  public Recruteur addCandidate(Recruteur recruteur) {
    
    recruteur.setRecruteurCode(UUID.randomUUID().toString());
 //   recruteur.setEmail(email);
        return recruteurRepository.save(recruteur);

    
  }
  
  
  public List<Recruteur> findAllRecruteurs(){
   return recruteurRepository.findAll();
   }
  
  
  public Recruteur updateRecruteur(Recruteur recruteur) {
    return recruteurRepository.save(recruteur);
  }
  
  
  public Recruteur findRecruteurById(Long id) {
    return recruteurRepository.findRecruteurById(id)
        .orElseThrow(() -> new RecruteurNotFoundException("Récruteur by id"+ id + "was not found"));
  }
  
  
  
  public void deleteRecruteur(Long id) {
    recruteurRepository.deleteRecruteurById(id);
  }



  
  
}
