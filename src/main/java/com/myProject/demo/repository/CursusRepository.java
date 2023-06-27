package com.myProject.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Cursus;

@Repository
public interface CursusRepository extends JpaRepository<Cursus, Long>{

  List<Cursus> findByUserId(Long userId);
  Optional<Cursus> findByIdAndUserId(Long id, Long userId);
  
  
}
