package com.myProject.demo.model;

import lombok.Data;

@Data
public class Hello {
  private String message;
  private String email;

  
  
  
public Hello(String message, String email) {
	super();
	this.message = message;
	this.email = email;
}
public Hello() {
	super();
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
