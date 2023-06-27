package com.myProject.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "parcours")
@Data
public  class ParcoursUniv {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;




  @Column(name = "diplome")
  private String diplome;
  


  @Column(name = "anneediplome")
  private String anneeDiplome;
  
  


  @Column(name = "universitydiplome")
  private String universityDiplome;

  
  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
 private User user ;




public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getDiplome() {
	return diplome;
}


public void setDiplome(String diplome) {
	this.diplome = diplome;
}


public String getAnneeDiplome() {
	return anneeDiplome;
}


public void setAnneeDiplome(String anneeDiplome) {
	this.anneeDiplome = anneeDiplome;
}


public String getUniversityDiplome() {
	return universityDiplome;
}


public void setUniversityDiplome(String universityDiplome) {
	this.universityDiplome = universityDiplome;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}







}


