package com.myProject.demo.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(name = "title", nullable = false) 
    private String title;
    
    @Lob
    @NotEmpty
    private String content;
    
    private Instant createdOn;
    
    private Instant updatedOn;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String imagePost;
    
    
    @NotBlank
    private String postText;

    @NotBlank
    private Timestamp timestamp;

    
    
    
    
    
	public Post() {
		super();
	}

	public Post(Long id, @NotBlank String title, @NotEmpty String content, Instant createdOn, Instant updatedOn,
			@NotBlank String username, @NotBlank String imagePost, @NotBlank String postText,
			@NotBlank Timestamp timestamp) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.username = username;
		this.imagePost = imagePost;
		this.postText = postText;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public Instant getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImagePost() {
		return imagePost;
	}

	public void setImagePost(String imagePost) {
		this.imagePost = imagePost;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

    


   
    


    
    
    
}