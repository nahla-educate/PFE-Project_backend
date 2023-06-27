package com.myProject.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Cursus;
import com.myProject.demo.model.FileDB;
import com.myProject.demo.model.ParcoursUniv;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
  
  public FileDB findFileById(Long id);
  List<FileDB> findByUserId(Long id);
  


}