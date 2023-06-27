package com.myProject.demo.service;



import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.myProject.demo.dto.ActualityDto;
import com.myProject.demo.dto.PostDto;
import com.myProject.demo.exception.PostNotFoundException;
import com.myProject.demo.model.Actuality;
import com.myProject.demo.model.Post;
import com.myProject.demo.repository.ActualityRepository;
import com.myProject.demo.repository.PostRepository;
import com.myProject.demo.service.AuthService;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ActualityService {

  @Autowired
  private AuthService authService;
  
  @Autowired
  private ActualityRepository actRepo;
  
  

  @Transactional
  public List<Actuality> showAllPosts() {
      List<Actuality> posts = actRepo.findAll();
      return posts.stream().map(this::mapFromDtoToPost).collect(toList());
  }
  
  
  
//  public void createPost(PostDto postDto) {
//    Post post = new Post();
//    post.setTitle(postDto.getTitle());
//    post.setContent(postDto.getContent());
//     User user = authService.getCurrentUser().orElseThrow(() ->new IllegalArgumentException("No user here"));
//    post.setUsername(user.getUsername());
//    post.setCreatedOn(Instant.now());
//    
//    postRepository.save(post);
//  }
  

  @Transactional
  public void createPost(Actuality postDto) {
      Actuality post = mapFromDtoToPost(postDto);
      actRepo.save(post);
  }

  @Transactional
  public ActualityDto readSinglePost(Long id) {
      Actuality post = actRepo.findActualityById(id);
      return mapFromPostToDto(post);
  }


  private ActualityDto mapFromPostToDto(Actuality post) {
      ActualityDto postDto = new ActualityDto();
      postDto.setId(post.getId());
      postDto.setTitle(post.getTitle());
      postDto.setContent(post.getContent());
      postDto.setUsername(post.getUsername());
      return postDto;
  } 

  private Actuality mapFromDtoToPost(Actuality postDto) {
    Actuality post = new Actuality();
    post.setTitle(postDto.getTitle());
    post.setContent(postDto.getContent());
    User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    post.setCreatedOn(Instant.now());
    System.out.println(post.getCreatedOn());
    post.setUsername(loggedInUser.getUsername());
    post.setUpdatedOn(Instant.now());
    return post;
}
}
