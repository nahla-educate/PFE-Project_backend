package com.myProject.demo.controller;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myProject.demo.message.ResponseFile;
import com.myProject.demo.message.ResponseMessage;
import com.myProject.demo.model.FileDB;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.FileDBRepository;
import com.myProject.demo.service.AuthService;
import com.myProject.demo.service.FileStorageService;


@Controller
@CrossOrigin("http://localhost:4200")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  

@Autowired
private AuthService authService; 



@Autowired
private FileDBRepository fileRepo; 


@PostMapping("/{id}")
public FileDB saveImage(@PathVariable("userId") Long userId, @RequestBody FileDB fileDB) {
 User user = authService.findUserById(userId);
 fileDB.setUser(user);
 return  fileRepo.save(fileDB);
}



  @PostMapping("/{userId}/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@PathVariable("userId") Long userId, @RequestParam("file") MultipartFile file) {
    String message = "";
    try {
      storageService.store(file, userId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/{userId}/files")

  public ResponseEntity<List<FileDB>> getListFiles(@PathVariable("userId") Long userId) {
    System.out.println("*******************************");

    System.out.println(fileRepo.findByUserId(userId));
    return ResponseEntity.status(HttpStatus.OK).body(fileRepo.findByUserId(userId));

//    List<ResponseFile> files = storageService.getAllFiles()
//        
//        .filter(file -> file.getUser().getId()==userId)
//        
//        .map(dbFile -> {
//      String fileDownloadUri = ServletUriComponentsBuilder
//          .fromCurrentContextPath()
//          .path("/files/")
//          .path(dbFile.getId())
//          .toUriString();
//
//      return new ResponseFile(
//          dbFile.getId(),
//          fileDownloadUri,
//          dbFile.getType(),
//          dbFile.getData().length);
//    }).collect(Collectors.toList());
//
//    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getId() + "\"")
        .body(fileDB.getData());
  }
}