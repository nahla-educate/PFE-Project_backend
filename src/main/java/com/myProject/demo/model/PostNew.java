package com.myProject.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
public class PostNew extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    
    private String username;
    
    
    private String imageBlog;
    
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;

    private String type;
    

@Column(name = "picByte", length = 500000)
private byte[] picByte;

    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
   private User user ;

    

	public PostNew() {
		super();
	}


	public PostNew(Long id, String username, String imageBlog, @NotNull @Size(max = 100) String title,
			@NotNull @Size(max = 250) String description, @NotNull String content, String type, byte[] picByte,
			User user) {
		super();
		this.id = id;
		this.username = username;
		this.imageBlog = imageBlog;
		this.title = title;
		this.description = description;
		this.content = content;
		this.type = type;
		this.picByte = picByte;
		this.user = user;
	}


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


	public String getImageBlog() {
		return imageBlog;
	}


	public void setImageBlog(String imageBlog) {
		this.imageBlog = imageBlog;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    

    
    
    
}
