package com.myProject.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="partenaire")
public class Partenaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name="firstNamePart")
	private String firstNamePart;
	
    @Column(name="lastNamePart")
	private String lastNamePart;
 
    
	@Column(name="emailpart")
	private String emailPart;
	
	@Column(name="namesociety")
	private String nameSociety;
	
	@Column(name="enclassement")
	private String enclassement;
	
	@Column(name="numeroTelephone")
	private int numeroTelephone;
	
	@Column(name="localisation")
	private String localisation;
	
	@Column(name="pays")
	private String pays;
	
	@Column(name = "picByte", length = 500000)
	private byte[] picByte;
	
	@Column(name="etat")
	private String etat; 
	
	





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}






	public String getFirstNamePart() {
		return firstNamePart;
	}






	public void setFirstNamePart(String firstNamePart) {
		this.firstNamePart = firstNamePart;
	}






	public String getLastNamePart() {
		return lastNamePart;
	}






	public void setLastNamePart(String lastNamePart) {
		this.lastNamePart = lastNamePart;
	}











	public String getEmailPart() {
		return emailPart;
	}

	public void setEmailPart(String emailPart) {
		this.emailPart = emailPart;
	}


	public String getNameSociety() {
		return nameSociety;
	}

	public void setNameSociety(String nameSociety) {
		this.nameSociety = nameSociety;
	}

	public String getEnclassement() {
		return enclassement;
	}

	public void setEnclassement(String enclassement) {
		this.enclassement = enclassement;
	}

	public int getNumeroTelephone() {
		return numeroTelephone;
	}






	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public void setNumeroTelephone(int numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}




	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}





	public String getEtat() {
		return etat;
	}





	public void setEtat(String etat) {
		this.etat = etat;
	}



}
