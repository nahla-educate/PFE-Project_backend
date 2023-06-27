package com.myProject.demo.security;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.myProject.demo.dto.PostDto;
import com.myProject.demo.exception.PostNotFoundException;
import com.myProject.demo.model.Post;
import com.myProject.demo.repository.PostRepository;
import com.myProject.demo.service.AuthService;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

  @Autowired
  private AuthService authService;
  
  @Autowired
  private PostRepository postRepository;
  
  

  @Transactional
  public List<PostDto> showAllPosts() {
      List<Post> posts = postRepository.findAll();
      return posts.stream().map(this::mapFromPostToDto).collect(toList());
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
  public void createPost(PostDto postDto) {
      Post post = mapFromDtoToPost(postDto);
      postRepository.save(post);
  }

  @Transactional
  public PostDto readSinglePost(Long id) {
      Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
      return mapFromPostToDto(post);
  }

  private PostDto mapFromPostToDto(Post post) {
      PostDto postDto = new PostDto();
      postDto.setId(post.getId());
      postDto.setTitle(post.getTitle());
      postDto.setContent(post.getContent());
      postDto.setUsername(post.getUsername());
      return postDto;
  } 

  private Post mapFromDtoToPost(PostDto postDto) {
    Post post = new Post();
    post.setTitle(postDto.getTitle());
    post.setContent(postDto.getContent());
    User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    post.setCreatedOn(Instant.now());
    post.setUsername(loggedInUser.getUsername());
    post.setUpdatedOn(Instant.now());
    return post;
}
}
