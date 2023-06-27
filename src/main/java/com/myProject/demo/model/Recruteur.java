package com.myProject.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name ="recruteur")
public class Recruteur {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long id;
  private String cin ;
  private String nom;
  private String prenom;
  private String telephone;
  private String imageUrl;
  private String email;
  private String poste;
  private String societe;
  private String etat; 


  @Column(nullable = false, updatable = false)
  private String recruteurCode;

  private Date date;

 
  




  public Long getId() {
    return id;
  }




  public void setId(Long id) {
    this.id = id;
  }




  public String getCin() {
    return cin;
  }




  public void setCin(String cin) {
    this.cin = cin;
  }




  public String getNom() {
    return nom;
  }




  public void setNom(String nom) {
    this.nom = nom;
  }




  public String getPrenom() {
    return prenom;
  }




  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }




  public String getTelephone() {
    return telephone;
  }




  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }




  public String getImageUrl() {
    return imageUrl;
  }




  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }




  public String getEmail() {
    return email;
  }




  public void setEmail(String email) {
    this.email = email;
  }




  public String getPoste() {
    return poste;
  }




  public void setPoste(String poste) {
    this.poste = poste;
  }




  public String getSociete() {
    return societe;
  }




  public void setSociete(String societe) {
    this.societe = societe;
  }




  public String getEtat() {
    return etat;
  }




  public void setEtat(String etat) {
    this.etat = etat;
  }




  public String getRecruteurCode() {
    return recruteurCode;
  }




  public void setRecruteurCode(String recruteurCode) {
    this.recruteurCode = recruteurCode;
  }




  public Date getDate() {
    return date;
  }




  public void setDate(Date date) {
    this.date = date;
  }




  public Recruteur(Long id, String cin, String nom, String prenom, String telephone, String imageUrl, String email,
      String poste, String societe, String etat, String recruteurCode, Date date) {
    super();
    this.id = id;
    this.cin = cin;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.imageUrl = imageUrl;
    this.email = email;
    this.poste = poste;
    this.societe = societe;
    this.etat = etat;
    this.recruteurCode = recruteurCode;
    this.date = date;
  }
  
  
  
public Recruteur() {
  
}
}

