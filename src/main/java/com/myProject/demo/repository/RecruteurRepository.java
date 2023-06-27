package com.myProject.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myProject.demo.model.Candidate;
import com.myProject.demo.model.Recruteur;

public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {
  
  void deleteRecruteurById(Long id);
  
Optional<Recruteur> findRecruteurById(Long id);
  


}
