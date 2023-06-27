package com.myProject.demo.service;


import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.myProject.demo.model.FileDB;
import com.myProject.demo.repository.FileDBRepository;
import com.myProject.demo.repository.UserRepository;



@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;
  
  @Autowired
  private UserRepository userRepo;

  public FileDB store(MultipartFile file, Long userId) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Optional<com.myProject.demo.model.User> user= this.userRepo.findUserById(userId);
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), user.get());

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}