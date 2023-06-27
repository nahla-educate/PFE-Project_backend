package com.myProject.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.myProject.demo.security.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;



@EnableWebSecurity
@CrossOrigin(origins ="http://localhost:4200")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
  
  @Autowired
  UserDetailsService userDetailsService;
  

  

  
  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
      return new JwtAuthenticationFilter();
  }
  
  
  
  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }
  
  
  @Override
  public void configure(HttpSecurity httpScurity) throws Exception{
    httpScurity.csrf().disable().authorizeRequests()
    .antMatchers("/api/auth/**","/recruteur/**","/upload","/files","/files/**","/api/posts/","/api/posts/**","/api/v1/**", "/api/auth/users/**","/**")
    .permitAll()
    .anyRequest()
    .authenticated();
    
    httpScurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    
    
  }
  
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    
  }



  
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) {
      web.ignoring()
              .antMatchers(HttpMethod.OPTIONS, "/**");
  }
  
  
  
  
  
  
  
  
}
