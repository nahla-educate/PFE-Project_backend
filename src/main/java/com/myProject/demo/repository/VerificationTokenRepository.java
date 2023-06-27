package com.myProject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.User;
import com.myProject.demo.model.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{
VerificationToken findByToken(String token);

VerificationToken findByUser(User user);
}

