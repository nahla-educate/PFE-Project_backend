package com.myProject.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.demo.dto.PostDto;
import com.myProject.demo.exception.ResourceNotFoundException;
import com.myProject.demo.model.PostNew;
import com.myProject.demo.repository.PostNewRepository;
import com.myProject.demo.security.PostService;

import java.io.IOException;

import javax.validation.Valid;

//the officiel one


@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/posts")
public class PostNewController {
  private byte[] bytes;
  
    @Autowired
    private PostNewRepository postRepository;
    
    @Autowired
    private PostService postServiceNew;
    
    

    @GetMapping
    public Page<PostNew> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    
    @PostMapping
    public PostNew createPost(@Valid @RequestBody PostNew post) {
        return postRepository.save(post);
    }

    @PutMapping("/{postId}")
    public PostNew updatePost(@PathVariable Long postId, @Valid @RequestBody PostNew postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
    

    @GetMapping("/getPost/{id}")
    public ResponseEntity<PostNew> findPost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postRepository.findPostById(id), HttpStatus.OK);
    }
    
    


    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

 
    @PostMapping("/telechargeImage")
   public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
   this.bytes = file.getBytes();
   }

   
    
    
}