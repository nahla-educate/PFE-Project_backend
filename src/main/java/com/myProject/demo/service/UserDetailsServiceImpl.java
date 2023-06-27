package com.myProject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myProject.demo.model.User;
import com.myProject.demo.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("No user found " + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                true, true, true, true,
                getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
    
    

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//      
//      // Get the user's username
//
//
//          
//          
//        User user = userRepository.findByEmail(email).orElseThrow(() ->
//                new UsernameNotFoundException("No user found " + email));
//        
////        return new org.springframework.security.core.userdetails.User(user.getEmail(),
////                user.getPassword(),
////                true, true, true, true,
////                getAuthorities("ROLE_USER"));
//        
//        UserDetails currentUser  =  new org.springframework.security.core.userdetails.User(((User) user).getEmail(),
//            user.getPassword(),
//            true, true, true, true,
//            getAuthorities("ROLE_USER"));
//   // System.out.println(currentUser);
//    return currentUser ;   
//    }
    
    
}