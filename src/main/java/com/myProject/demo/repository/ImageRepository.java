package com.myProject.demo.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myProject.demo.model.ImageModel;


public interface ImageRepository extends JpaRepository<ImageModel, Long> {
  Optional<ImageModel> findByName(String name);
}
