package com.myProject.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

public class EmailModel {

  @NotNull
  private String name;
  
  @NotNull
  @Email
  private String email;
  
  @NotNull
  @Min(10)
  private String emailModel;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailModel() {
    return emailModel;
  }

  public void setEmailModel(String emailModel) {
    this.emailModel = emailModel;
  }
  
  
  
  
}
