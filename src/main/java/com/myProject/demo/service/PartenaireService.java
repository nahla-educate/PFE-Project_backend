package com.myProject.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.demo.model.Partenaire;
import com.myProject.demo.repository.PartenaireRepository;

@Service
public class PartenaireService {
	@Autowired
	private PartenaireRepository repo;
	
	public List<Partenaire> getPartenaires() {
		return repo.findPartenaireValide();
	}
	
	public List<Partenaire> getPartenairesAll() {
		return repo.findAll();
		}
	public Partenaire savePart(Partenaire part) {
		return repo.save(part);
	}
	
	public void deletePartenaire(Long id) {
		repo.deleteById(id);
	}
	
	 
	 /* public void part(RegisterRequest registerRequest) {
		  Partenaire part = new Partenaire();
	    
		  part.setFirstNamePart(registerRequest.getFirstNamePart());
		  part.setLastNamePart(registerRequest.getLastNamePart());
	  
		  Partenaire.setCreated(Instant.now());
	   

	   
	    //user.setEnabled(true);
	 //disabled new user before activation
	    user.setEnabled(false);
	    
	    //userRepository.save(user);
	    Optional<User> saved = Optional.of( userRepository.save(user));
	
	  }*/
}
