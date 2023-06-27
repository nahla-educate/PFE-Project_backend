package com.myProject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myProject.demo.model.CandidateUser;
import com.myProject.demo.model.Post;
import com.myProject.demo.model.User;

public interface PostRepository extends JpaRepository<Post, Long> {

}
