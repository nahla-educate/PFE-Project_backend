package com.myProject.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Candidate;
import com.myProject.demo.model.CandidateUser;
import com.myProject.demo.model.User;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

  <Optional> User save(CandidateUser candidate);
  


  
}
