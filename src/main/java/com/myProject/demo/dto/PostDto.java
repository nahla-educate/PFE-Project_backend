package com.myProject.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
  private Long id;
  private String content;
  private String title;
  private String username;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

  
  
}