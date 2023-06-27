package com.myProject.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursus")
@Valid 
@AllArgsConstructor
@NoArgsConstructor
public class Cursus extends AuditModel{
  
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  
  
  @Column(name = "diplome")
  private String diplome;

  
  @Column(name = "anneeDiplome")
  private String anneeDiplome;


  @Column(name = "universiteDiplome")
  private String universiteDiplome;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;
  
  
  @Column
  private String userIdf;



public int getId() {
	return id;
}


public void setId(int id) {
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


public String getUniversiteDiplome() {
	return universiteDiplome;
}


public void setUniversiteDiplome(String universiteDiplome) {
	this.universiteDiplome = universiteDiplome;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public String getUserIdf() {
	return userIdf;
}


public void setUserIdf(String userIdf) {
	this.userIdf = userIdf;
}


@Override
  public String toString() {
      return "Cursus [id=" + id + ", diplome=" + diplome +", universiteDiplome=" + universiteDiplome +", anneeDiplome=" + anneeDiplome + userIdf +  "]";
  }


}

