package com.myProject.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myProject.demo.model.Comment;
import com.myProject.demo.model.Cursus;
import com.myProject.demo.model.ParcoursUniv;

public interface ParcoursUnivRepository extends JpaRepository<ParcoursUniv, Long> {
  List<ParcoursUniv> findByUserId(Long userId);

  public ParcoursUniv findParcoursById(Long id);

  
}
