package com.myProject.demo.service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.demo.model.ParcoursUniv;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.ParcoursUnivRepository;

@Service
public class ParcoursUnivService {
  
  
  @Autowired
  private ParcoursUnivRepository parcoursRepo;
  
  
  public ParcoursUniv saveParcoursUniv(ParcoursUniv parccours) {
    return parcoursRepo.save(parccours);
  }




}
