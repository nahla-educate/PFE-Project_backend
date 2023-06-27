package com.myProject.demo.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.demo.model.Partenaire;
import com.myProject.demo.repository.PartenaireRepository;
import com.myProject.demo.service.PartenaireService;



@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/part")
public class PartenaireController {
	private byte[] bytes;
	
	@Autowired
	private PartenaireService service;
	
	@Autowired
	private PartenaireRepository repo;
		
		
	@GetMapping("/getPart")
	public List<Partenaire> getPartenaires(){
		return service.getPartenaires();
	}
	
	@GetMapping("/getPartAll")
	public List<Partenaire> getPartenairesAll(){
		return service.getPartenairesAll();
	}
	
	@PostMapping("/telecharge")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@PostMapping("/partenaires")
	public void add(@RequestBody Partenaire partenaire) {
		partenaire.setPicByte(this.bytes);
		partenaire.setEtat("Invalid");
		service.savePart(partenaire);
		this.bytes = null;
	}
	
	@DeleteMapping("/partenaires/{id}/delete")
	public void deletePart(@PathVariable("id") Long id) {
		service.deletePartenaire(id);
	}
	@PutMapping("/validePart/{id}")
    public ResponseEntity<Partenaire> ValidePart(@PathVariable("id") Long id ,@RequestBody Partenaire part ){
	   Optional<Partenaire>c=repo.findById(id);
	   c.equals(part);
	   part.setEtat("valide");
	   repo.save(part);
	   return new ResponseEntity<>(part, HttpStatus.CREATED);
	  }
	

}
