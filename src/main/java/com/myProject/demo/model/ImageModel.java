package com.myProject.demo.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "image_table")
public class ImageModel {



 /* public ImageModel(String name, String type, byte[] picByte) {
    this.name = name;
    this.type = type;
    this.picByte = picByte;
  }*/

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;
  
  private String username;


    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
  @Column(name = "picByte", length = 1000)
  private byte[] picByte;


/*public ImageModel(Long id, String name, String type, String username, byte[] picByte) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.username = username;
	this.picByte = picByte;
}*/


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public byte[] getPicByte() {
	return picByte;
}


public void setPicByte(byte[] picByte) {
	this.picByte = picByte;
}


}