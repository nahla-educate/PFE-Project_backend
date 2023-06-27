package com.myProject.demo.dto;



public class DecisionMessage {

  private String name;

  public DecisionMessage() {
  }

  public DecisionMessage(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
}