package com.myProject.demo.model;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "verificationtoken")
public class VerificationToken {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="token")
private String token;

@Column(name="expiry_date")
private Timestamp expiryDate;

@OneToOne( cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinColumn( name = "user_id", referencedColumnName = "id")
private User user;

public VerificationToken() {

}

 


public VerificationToken(Long id, String token, Timestamp expiryDate, User user) {
	super();
	this.id = id;
	this.token = token;
	this.expiryDate = expiryDate;
	this.user = user;
}




public VerificationToken(String token, User user) {
super();
this.token = token;
this.user = user;
}



public Long getId() {
return id;
}



public void setId(Long id) {
this.id = id;
}



public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public Timestamp getExpiryDate() {
return expiryDate;
}

public void setExpiryDate(Timestamp expiryDate) {
this.expiryDate = expiryDate;
}




public User getUser() {
return user;
}




public void setUser(User user) {
this.user = user;
}



}