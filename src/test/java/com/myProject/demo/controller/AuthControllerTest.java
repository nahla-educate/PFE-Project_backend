package com.myProject.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.myProject.demo.dto.RegisterRequest;
import com.myProject.demo.repository.CandidateRepository;
import com.myProject.demo.repository.UserRepository;
import com.myProject.demo.service.AuthService;


@RunWith(SpringRunner.class)
class AuthControllerTest {
//  @Mock
//  private AuthService authService;
  
  // mocking is creating objects that simulate the behavior of real objects.
private final AuthService authService = mock(AuthService.class);
  

  private final UserRepository userRepository = mock(UserRepository.class);

  
  private final  CandidateRepository candRepo = mock(CandidateRepository.class);

  
  private AuthController authController= new AuthController(authService, userRepository, candRepo, null, null, null, null);
  
  //@BeforeClass
//  public void setUp() {
//    this.authController.setAuthService(authService);
//    this.authController.setCandRepo(candRepo);
//    this.authController.setUserRepository(userRepository);
//  }
  
  
  @Test
  void should_return_success_after_signup() {
    //GIVEN
    RegisterRequest request = new RegisterRequest();
    doNothing().when(authService).signup(request);
    //WHEN
    ResponseEntity response = authController.signup(request);
    //THEN
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
  
  
  
  
  @Test
  void should_return_failure_when_request_is_null() {
    //GIVEN

    //WHEN
 assertThrows(RuntimeException.class, () -> authController.signup(null));

    //THEN

  }

}
