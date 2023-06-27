package com.myProject.demo.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Cursus;
import com.myProject.demo.model.ParcoursUniv;
import com.myProject.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
  Optional<User> findByEmail(String email);
  Optional<User> findUserById(Long id);
  Optional<User> findByEtat(String etat);

  User findUserByEmail(String email);
  ParcoursUniv save(ParcoursUniv parcoursUniv);

 // Cursus save(Cursus cursus);


}
