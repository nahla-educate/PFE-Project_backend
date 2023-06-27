package com.myProject.demo.service;


import java.sql.Timestamp;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.demo.model.User;
import com.myProject.demo.model.VerificationToken;
import com.myProject.demo.repository.VerificationTokenRepository;

@Service
public class VerificationTokenService {
private final VerificationTokenRepository verificationTokenRepository;

@Autowired
public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
this.verificationTokenRepository = verificationTokenRepository;
}

public VerificationToken findByToken(String token) {
return verificationTokenRepository.findByToken(token);
}

@Transactional
public VerificationToken findByUser(User user) {
return verificationTokenRepository.findByUser(user);
}

public void save(User user, String token) {
VerificationToken verificationToken = new VerificationToken(token, user);
//set expiry date to 24 hours
verificationToken.setExpiryDate(calculateExpiryDate(24*60));
verificationTokenRepository.save(verificationToken);
}

//calculate expiry date
private Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
Calendar cal = Calendar.getInstance();
cal.add(Calendar.MINUTE, expiryTimeInMinutes);
return new Timestamp(cal.getTime().getTime());
}

}