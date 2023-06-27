package com.myProject.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.demo.model.Notification;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.NotificationRepository;
import com.myProject.demo.repository.UserRepository;
import com.myProject.demo.service.AuthService;
import com.myProject.demo.service.NotificationService;


@RestController
@RequestMapping("/notification")
@CrossOrigin(origins ="http://localhost:4200")
public class NotificationController {

	@Autowired
	private NotificationService service;
	
	@Autowired
	private NotificationRepository notificationrepo;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired NotificationRepository notificationRepository; 
	
	@Autowired
	  private AuthService authService;
	
    @PostMapping("/sendNotification/{userId}")
    	public void sendMessage(@PathVariable("userId") Long userId, @RequestBody Notification notif) {
    		User candidate = userRepository.getOne(userId);
    		notif.setValue("Vous avez une demande de recrutement");
    		notif.setStatut(false);
    		notif.setCandidat(candidate);
    		service.saveNotif(notif);
    		//User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    	//	notif.setUsername(loggedInUser.getUsername());
    	}
    	
    	@GetMapping("/{userId}")
    	public ResponseEntity<List<Notification>> getNot(@PathVariable Long userId) {
    		return this.service.getNot(userId);
    	}
    
    	@PutMapping("/updateNotification")
        public ResponseEntity<Notification> updateNotification(@RequestBody Notification notification) {
            notification.setStatut(true);
            service.saveNotif(notification);

            return new ResponseEntity<Notification>(HttpStatus.OK);
        }
    	
    	@GetMapping("nombreNotification/{userId}")
    	public Long getNombreNotificationNonLu(@PathVariable Long userId) {
    		
    		return notificationRepository.nombreNotificationNonLu(userId);
    	}
    	
    	@GetMapping("getNotificationById/{notificationId}")
    	public Optional<Notification> getNotificationById(@PathVariable Long notificationId) {
    		return this.notificationrepo.findById(notificationId);
    	}
}