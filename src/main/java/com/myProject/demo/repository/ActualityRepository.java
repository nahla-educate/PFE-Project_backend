package com.myProject.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Actuality;






@Repository
public interface ActualityRepository  extends JpaRepository<Actuality, Long> {
  
  Actuality findActualityById(Long actId);



}