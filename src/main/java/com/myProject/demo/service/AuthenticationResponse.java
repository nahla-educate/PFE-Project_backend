package com.myProject.demo.service;

import java.util.List;

import com.myProject.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthenticationResponse {
private String authenticationToken;
 //private String email;
  private User user;
public AuthenticationResponse(String authenticationToken, User user) {
	super();
	this.authenticationToken = authenticationToken;
	this.user = user;
}
public AuthenticationResponse() {
	super();
}
public String getAuthenticationToken() {
	return authenticationToken;
}
public void setAuthenticationToken(String authenticationToken) {
	this.authenticationToken = authenticationToken;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
  
 //  private List userDetails;
  
  
  
  
  

}
