package com.myProject.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myProject.demo.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	//Notification findNotificationByUser(User user);
	
		//List<Notification> findNotificationByUser(User user);
		
		 /*@Query ("select i.userId, count(i) from Notification i where i.userId =?1")
		    int count();*/
		@Query(
				value = "SELECT count(id) FROM notification WHERE id_condidat = :userId AND statut = 0",
				nativeQuery = true)
		Long nombreNotificationNonLu(Long userId);

}