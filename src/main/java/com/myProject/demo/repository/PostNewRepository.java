package com.myProject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.PostNew;




@Repository
public interface PostNewRepository  extends JpaRepository<PostNew, Long> {
  
  PostNew findPostById(Long postId);


}