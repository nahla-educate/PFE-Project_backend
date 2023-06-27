package com.myProject.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.myProject.demo.exception.RecruteurNotFoundException;
import com.myProject.demo.exception.ResourceNotFoundException;
import com.myProject.demo.model.Candidate;
import com.myProject.demo.model.Recruteur;
import com.myProject.demo.repository.RecruteurRepository;
import com.myProject.demo.service.RecruteurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recruteur")
public class RecruteurController {
  
  
  private final RecruteurService recruteurService;
  @Autowired
  private RecruteurRepository recruteurRepository;

 public RecruteurController(RecruteurService recruteurService) {
   this.recruteurService = recruteurService;
 }
  
 
  @GetMapping("/all")
  public ResponseEntity<List<Recruteur>> getAllRecruteurs(){
    List<Recruteur> recruteurs = recruteurService.findAllRecruteurs();
    return new ResponseEntity<>(recruteurs, HttpStatus.OK);
  }
  
  
  
  @GetMapping("/find/{id}")
  public ResponseEntity<Recruteur> getRecruteurById(@PathVariable("id") Long id){
Recruteur recruteur = recruteurService.findRecruteurById(id); 
return new ResponseEntity<>(recruteur, HttpStatus.OK);
  }
  

  
  @PutMapping("/valideCompte/{id}")
  public ResponseEntity<Recruteur> ValiderRec(@PathVariable("id") Long id ,@RequestBody Recruteur rec ){
   Optional<Recruteur>c=recruteurRepository.findById(id);
   c.equals(rec);
   rec.setEtat("valide");
   recruteurRepository.save(rec);
  
    return new ResponseEntity<>(rec, HttpStatus.CREATED);
  }
  
  

  

  @PostMapping("/add")
  public ResponseEntity<Recruteur> addRecruteur(@RequestBody  Recruteur recruteur) {
   Recruteur newRecruteur= recruteurService.addCandidate(recruteur);
   newRecruteur.setEtat("Invalid");
   recruteurRepository.save(newRecruteur);
    return new ResponseEntity<>(newRecruteur, HttpStatus.CREATED);

  }


  
  @PutMapping("/update")
  public ResponseEntity<Recruteur> updateRecruteur(@RequestBody Recruteur recruteur) {
    Recruteur updateRecruteur = recruteurService.updateRecruteur(recruteur);
    return new ResponseEntity<>(updateRecruteur, HttpStatus.OK);
  }

  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteRecruteur(@PathVariable("id") Long id) {
    recruteurService.deleteRecruteur(id);
    return new ResponseEntity<>(HttpStatus.OK);

  }
  
  
  

 
  
  
  
}
