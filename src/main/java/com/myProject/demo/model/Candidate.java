package com.myProject.demo.model;


import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidates" )
public class Candidate implements Serializable {
 
  private static final long serialVersionUID = 1L;

  

  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private long id;
  
  @Column(name="imageUrl")
  private String imageUrl;
  
  @Column(name="cin")
  private String cin; 
  
  @Column(name="nom")
  private String nom ;
  
  
  @Column(name="prenom")
  private String prenom ;
  
  @Column(name="telephone")
  private String telephone;
  
  
  
  @Column(name="adresse")
  private String adresse;
  
  
  @Column(name="emailId")
  private String emailId;
  
  @Column(name="ville")
  private String ville;
  
  
  @Column(name="pays")
  private String pays;
  
  
  @Column(name="universite")
  private String universite;
  
  
  @Column(name="societe")
  private String societe;
  
  
  
  @Column(name="formation")
  private String formation;
  
  
  @Column(name="certification")
  private String certification;
  
  
  
  @Column(name="stage")
  private String stage;
  
  
  @Column(name="societeStage")
  private String societeStage;
  
  
  @Column(name="poste")
  private String poste;
  
  
  @Column(name="duree")
  private String duree;
  
  @Column(name="apropos")
  private String apropos ;
  
  
  @Column(name="fichier")
  private File fichier;
  
  @Column(name="sitAmoureuse")
  private String sitAmoureuse;

  
  @Column(name="duree1")
  private String duree1;
  
  
  
  
  public Candidate(String cin, String imageUrl, String nom, String prenom, String telephone, String emailId, String universite,
      String societe, String formation, String certification, String stage, String societeStage, String poste,
      String duree, String adresse, String apropos ,File fichier, String ville, String pays, String sitAmoureuse) {
    super();
    this.cin = cin;
    this.imageUrl= imageUrl;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.emailId = emailId;
    this.universite = universite;
    this.societe = societe;
    this.formation = formation;
    this.certification = certification;
    this.stage = stage;
    this.societeStage = societeStage;
    this.poste = poste;
    this.duree = duree;
    this.adresse = adresse;
    this.apropos = apropos;
    this.fichier = fichier;
    this.ville =ville;
    this.pays=pays;
    this.sitAmoureuse = sitAmoureuse;
  }


  
  
  
 public String getSitAmoureuse() {
    return sitAmoureuse;
  }





  public void setSitAmoureuse(String sitAmoureuse) {
    this.sitAmoureuse = sitAmoureuse;
  }





public String getApropos() {
    return apropos;
  }


  public String getVille() {
    return ville;
  }




  public void setVille(String ville) {
    this.ville = ville;
  }







  public String getPays() {
    return pays;
  }







  public void setPays(String pays) {
    this.pays = pays;
  }







  public void setApropos(String apropos) {
    this.apropos = apropos;
  }














  public String getImageUrl() {
    return imageUrl;
  }














  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }














  public String getAdresse() {
    return adresse;
  }














  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }


  public String getCertification() {
    return certification;
  }


  public void setCertification(String certification) {
    this.certification = certification;
  }


  public String getStage() {
    return stage;
  }


  public void setStage(String stage) {
    this.stage = stage;
  }


  public String getSocieteStage() {
    return societeStage;
  }


  public void setSocieteStage(String societeStage) {
    this.societeStage = societeStage;
  }


  public String getPoste() {
    return poste;
  }


  public void setPoste(String poste) {
    this.poste = poste;
  }


  public String getDuree() {
    return duree;
  }


  public void setDuree(String duree) {
    this.duree = duree;
  }


  public Candidate(String nom, String prenom, String emailId) {
    super();
    this.nom = nom;
    this.prenom = prenom;
    this.emailId = emailId;
  }

  
  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  
  
  public String getCin() {
    return cin;
  }


  public void setCin(String cin) {
    this.cin = cin;
  }


  public String getPrenom() {
    return prenom;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  public String getEmailId() {
    return emailId;
  }
  public void setEmail(String emailId) {
    this.emailId = emailId;
  }


  public String getTelephone() {
    return telephone;
  }


  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getUniversite() {
    return universite;
  }


  public void setUniversite(String universite) {
    this.universite = universite;
  }


  public String getSociete() {
    return societe;
  }


  public void setSociete(String societe) {
    this.societe = societe;
  }


  public String getFormation() {
    return formation;
  }


  public void setFormation(String formation) {
    this.formation = formation;
  }


  public Candidate(String cin ,String nom, String prenom, String telephone, String emailId, String universite,
      String societe, String formation) {
    super();
this.cin = cin;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.emailId = emailId;
    this.universite = universite;
    this.societe = societe;
    this.formation = formation;
  }

  
  public Candidate() {
    
  }
  
  
  
  }