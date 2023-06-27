package com.myProject.demo.model;



import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
public class User  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;
    
    
    @Column
    private String username;
    
    @Column
    private String password;
    
    private String cpassword;

    
    @Column(unique = true)
    private String email;

    //@Lob
	@Column(name = "imageUrl")
   private byte[] imageUrl;
    
    @Column
    private Instant created;
    
  //   @Column
    private boolean enabled;
    
    @Column
    private String poste;
    
    @Column
    private String etat ;
    
    
    @Column 
    private String role;
    
    @Column
    private String adresse; 
    
    
    @Column
    private String experience;
    
    @Column
    private String cinCand;
    
    
    @Column
    private String nomCand;
    
    
    
    @Column
    private String prenomCand;
    
  
    
    @Column
    private String telephoneCand;
    
    
    @Column
    private String telephone;;
    
    
    @Column
    private String emailCand;
    
    
    
    @Column
    private String adresseCand;
    
    
    private String message;
    
    
    @Column
    private String villeCand;
    
    @Column
    private String paysCand;
   
    
    @Column
    private String certificationCand;
    
    
    
    @Column
    private String stageCand;
    
    
    
    
    @Column
    private String societeStaCand;
    
    
    
    
    @Column
    private String societeProCand;
    
    
    
    @Column
    private String posteProCand;
    
    
    
    @Column
    private String dureeProCand;
    
    

    @Column(name="apropos")
    private String apropos ;
    
    
    @Column(name="cv")
    private File cv;
    
    @Column(name="lm")
    private File lm;
    
    
    @Column(name="files")
    private File autresFiles;
    
    
    @Column(name="sitAmoureuse")
    private String sitAmoureuse;

    
    @Column(name="duree1")
    private Instant duree1;
    
    private String pays;
    private String postal;
    
    
  @OneToMany(cascade = CascadeType.ALL)
private List<ParcoursUniv> cursus = new ArrayList<>();

  
@OneToMany(cascade = CascadeType.ALL)
private List<FileDB> imageBlog = new ArrayList<>();

    

@JsonIgnore
@OneToMany(mappedBy = "candidat")
private List<Notification> notifications;








public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getCpassword() {
	return cpassword;
}



public void setCpassword(String cpassword) {
	this.cpassword = cpassword;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public byte[] getImageUrl() {
	return imageUrl;
}



public void setImageUrl(byte[] imageUrl) {
	this.imageUrl = imageUrl;
}



public Instant getCreated() {
	return created;
}



public void setCreated(Instant created) {
	this.created = created;
}



public boolean isEnabled() {
	return enabled;
}



public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}



public String getPoste() {
	return poste;
}



public void setPoste(String poste) {
	this.poste = poste;
}



public String getEtat() {
	return etat;
}



public void setEtat(String etat) {
	this.etat = etat;
}



public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = role;
}



public String getAdresse() {
	return adresse;
}



public void setAdresse(String adresse) {
	this.adresse = adresse;
}



public String getExperience() {
	return experience;
}



public void setExperience(String experience) {
	this.experience = experience;
}



public String getCinCand() {
	return cinCand;
}



public void setCinCand(String cinCand) {
	this.cinCand = cinCand;
}



public String getNomCand() {
	return nomCand;
}



public void setNomCand(String nomCand) {
	this.nomCand = nomCand;
}



public String getPrenomCand() {
	return prenomCand;
}



public void setPrenomCand(String prenomCand) {
	this.prenomCand = prenomCand;
}



public String getTelephoneCand() {
	return telephoneCand;
}



public void setTelephoneCand(String telephoneCand) {
	this.telephoneCand = telephoneCand;
}



public String getTelephone() {
	return telephone;
}



public void setTelephone(String telephone) {
	this.telephone = telephone;
}



public String getEmailCand() {
	return emailCand;
}



public void setEmailCand(String emailCand) {
	this.emailCand = emailCand;
}



public String getAdresseCand() {
	return adresseCand;
}



public void setAdresseCand(String adresseCand) {
	this.adresseCand = adresseCand;
}



public String getMessage() {
	return message;
}



public void setMessage(String message) {
	this.message = message;
}



public String getVilleCand() {
	return villeCand;
}



public void setVilleCand(String villeCand) {
	this.villeCand = villeCand;
}



public String getPaysCand() {
	return paysCand;
}



public void setPaysCand(String paysCand) {
	this.paysCand = paysCand;
}



public String getCertificationCand() {
	return certificationCand;
}



public void setCertificationCand(String certificationCand) {
	this.certificationCand = certificationCand;
}



public String getStageCand() {
	return stageCand;
}



public void setStageCand(String stageCand) {
	this.stageCand = stageCand;
}



public String getSocieteStaCand() {
	return societeStaCand;
}



public void setSocieteStaCand(String societeStaCand) {
	this.societeStaCand = societeStaCand;
}



public String getSocieteProCand() {
	return societeProCand;
}



public void setSocieteProCand(String societeProCand) {
	this.societeProCand = societeProCand;
}



public String getPosteProCand() {
	return posteProCand;
}



public void setPosteProCand(String posteProCand) {
	this.posteProCand = posteProCand;
}



public String getDureeProCand() {
	return dureeProCand;
}



public void setDureeProCand(String dureeProCand) {
	this.dureeProCand = dureeProCand;
}



public String getApropos() {
	return apropos;
}



public void setApropos(String apropos) {
	this.apropos = apropos;
}



public File getCv() {
	return cv;
}



public void setCv(File cv) {
	this.cv = cv;
}



public File getLm() {
	return lm;
}



public void setLm(File lm) {
	this.lm = lm;
}



public File getAutresFiles() {
	return autresFiles;
}



public void setAutresFiles(File autresFiles) {
	this.autresFiles = autresFiles;
}



public String getSitAmoureuse() {
	return sitAmoureuse;
}



public void setSitAmoureuse(String sitAmoureuse) {
	this.sitAmoureuse = sitAmoureuse;
}



public Instant getDuree1() {
	return duree1;
}



public void setDuree1(Instant duree1) {
	this.duree1 = duree1;
}



public String getPays() {
	return pays;
}



public void setPays(String pays) {
	this.pays = pays;
}



public String getPostal() {
	return postal;
}



public void setPostal(String postal) {
	this.postal = postal;
}



public List<ParcoursUniv> getCursus() {
	return cursus;
}



public void setCursus(List<ParcoursUniv> cursus) {
	this.cursus = cursus;
}



public List<FileDB> getImageBlog() {
	return imageBlog;
}



public void setImageBlog(List<FileDB> imageBlog) {
	this.imageBlog = imageBlog;
}



public List<Notification> getNotifications() {
	return notifications;
}



public void setNotifications(List<Notification> notifications) {
	this.notifications = notifications;
}


 /*@JsonIgnore
 @OneToMany(mappedBy="user", orphanRemoval=true,cascade = CascadeType.ALL)
 private List<Notification> notifications;*/


   

// @OneToMany(mappedBy = "user", cascade = {
//     CascadeType.ALL    })
//   private List < Cursus > cursus;
//
//   
    
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "user_roles", 
//          joinColumns = @JoinColumn(name = "user_id"), 
//          inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    
    
//    @Enumerated(EnumType.STRING)
//    @Column
//    private ERole role;
//    

//    public Set<Role> getRoles() {
//      return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//      this.roles = roles;
//    }


}