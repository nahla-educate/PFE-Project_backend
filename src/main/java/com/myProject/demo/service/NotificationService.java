package com.myProject.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myProject.demo.model.Notification;
import com.myProject.demo.model.User;
import com.myProject.demo.repository.NotificationRepository;
import com.myProject.demo.repository.UserRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository notificationrepo;

	@Autowired
	private UserRepository userRepository;
	
	public Notification saveNotif(Notification notif) {
		return notificationrepo.save(notif);
	}


	public ResponseEntity<List<Notification>> getNot(Long userId) {
		Optional<User> candidate = this.userRepository.findById(userId);
		if (candidate.isPresent()) {
			return ResponseEntity.status(200).body(candidate.get().getNotifications());
			//return notificationrepo.findNotificationByUser(candidate);
		}else {
			return ResponseEntity.status(404).body(null);
		}
	}
	
	 /*public int count() {
	        return notificationrepo.count();
	    }*/


}