package com.myProject.demo.exception;

public class PostNotFoundException extends RuntimeException {
  
  public PostNotFoundException(String message) {
    super(message);
  }

}
