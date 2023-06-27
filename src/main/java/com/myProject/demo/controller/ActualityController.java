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
import com.myProject.demo.model.Actuality;
import com.myProject.demo.model.PostNew;
import com.myProject.demo.repository.ActualityRepository;
import com.myProject.demo.repository.PostNewRepository;
import com.myProject.demo.security.PostService;
import com.myProject.demo.service.ActualityService;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

//the officiel one


@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/actualities")
public class ActualityController {
  private byte[] bytes;
  
    @Autowired
    private ActualityRepository actRepository;
    
    @Autowired
    private ActualityService actService;
    
    

    @GetMapping
    public List<Actuality> getAllPosts() {
        return actRepository.findAll();
    }


    @PostMapping
    public Actuality createPost(@Valid @RequestBody Actuality post) {
        return actRepository.save(post);
    }

    @PutMapping("/{postId}")
    public Actuality updatePost(@PathVariable Long postId, @Valid @RequestBody Actuality postRequest) {
        return actRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return actRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
    

    @GetMapping("/getPost/{id}")
    public ResponseEntity<Actuality> findPost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(actRepository.findActualityById(id), HttpStatus.OK);
    }
    
    


    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return actRepository.findById(postId).map(post -> {
          actRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

}