package com.myProject.demo.controller;


import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.myProject.demo.dto.LoginRequest;
import com.myProject.demo.dto.RegisterRequest;
import com.myProject.demo.exception.ResourceNotFoundException;
import com.myProject.demo.model.Cursus;
import com.myProject.demo.model.FileDB;
import com.myProject.demo.model.ParcoursUniv;
import com.myProject.demo.model.User;
import com.myProject.demo.model.VerificationToken;
import com.myProject.demo.repository.CandidateRepository;
import com.myProject.demo.repository.FileDBRepository;
import com.myProject.demo.repository.ParcoursUnivRepository;
import com.myProject.demo.repository.UserRepository;
import com.myProject.demo.service.AuthService;
import com.myProject.demo.service.AuthenticationResponse;
import com.myProject.demo.service.VerificationTokenService;

import io.jsonwebtoken.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Data;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins ="http://localhost:4200")
@Data
@AllArgsConstructor
public class AuthController {
  
  @Autowired
  private AuthService authService;
  
  
  @Autowired
  private UserRepository userRepository;

  
  
  @Autowired
  private CandidateRepository candRepo;
  
  @Autowired
  private ParcoursUnivRepository  parcoursRepo;



  @Autowired
  private FileDBRepository  fileRepo;
  
  @Autowired
  private VerificationTokenService verificationTokenService;
 

  
  @PostMapping("/signup")
  public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
    if(registerRequest == null) {
     throw new NullPointerException(); 
    }else {
    authService.signup(registerRequest);
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  
  @GetMapping("/activation")
  public String activation(@RequestParam("token") String token, Model model) throws FileNotFoundException, IOException{
	  //create html page activation
	  VerificationToken verificationToken = verificationTokenService.findByToken(token);
	  if(verificationToken == null) {
		  model.addAttribute("message", "Votre verification token is invalid");
		  
	  }else {
		  User user = verificationToken.getUser();
		  
		  //if the user account is not activated
		  if(!user.isEnabled()) {
			  //get the current timestamp
			  Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			 // check if the token is expired
			  if(verificationToken.getExpiryDate().before(currentTimestamp)) {
				  return "<!DOCTYPE html>\r\n"
					  		+ "<html>\r\n"
					  		+ "\r\n"
					  		+ "<head>\r\n"
					  		+ "    <title></title>\r\n"
					  		+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n"
					  		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					  		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
					  		+ "    <style type=\"text/css\">\r\n"
					  		+ "        @media screen {\r\n"
					  		+ "            @font-face {\r\n"
					  		+ "                font-family: 'Lato';\r\n"
					  		+ "                font-style: normal;\r\n"
					  		+ "                font-weight: 400;\r\n"
					  		+ "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\r\n"
					  		+ "            }\r\n"
					  		+ "\r\n"
					  		+ "            @font-face {\r\n"
					  		+ "                font-family: 'Lato';\r\n"
					  		+ "                font-style: normal;\r\n"
					  		+ "                font-weight: 700;\r\n"
					  		+ "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\r\n"
					  		+ "            }\r\n"
					  		+ "\r\n"
					  		+ "            @font-face {\r\n"
					  		+ "                font-family: 'Lato';\r\n"
					  		+ "                font-style: italic;\r\n"
					  		+ "                font-weight: 400;\r\n"
					  		+ "                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\r\n"
					  		+ "            }\r\n"
					  		+ "\r\n"
					  		+ "            @font-face {\r\n"
					  		+ "                font-family: 'Lato';\r\n"
					  		+ "                font-style: italic;\r\n"
					  		+ "                font-weight: 700;\r\n"
					  		+ "                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\r\n"
					  		+ "            }\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        /* CLIENT-SPECIFIC STYLES */\r\n"
					  		+ "        body,\r\n"
					  		+ "        table,\r\n"
					  		+ "        td,\r\n"
					  		+ "        a {\r\n"
					  		+ "            -webkit-text-size-adjust: 100%;\r\n"
					  		+ "            -ms-text-size-adjust: 100%;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        table,\r\n"
					  		+ "        td {\r\n"
					  		+ "            mso-table-lspace: 0pt;\r\n"
					  		+ "            mso-table-rspace: 0pt;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        img {\r\n"
					  		+ "            -ms-interpolation-mode: bicubic;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        /* RESET STYLES */\r\n"
					  		+ "        img {\r\n"
					  		+ "            border: 0;\r\n"
					  		+ "            height: auto;\r\n"
					  		+ "            line-height: 100%;\r\n"
					  		+ "            outline: none;\r\n"
					  		+ "            text-decoration: none;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        table {\r\n"
					  		+ "            border-collapse: collapse !important;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        body {\r\n"
					  		+ "            height: 100% !important;\r\n"
					  		+ "            margin: 0 !important;\r\n"
					  		+ "            padding: 0 !important;\r\n"
					  		+ "            width: 100% !important;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        /* iOS BLUE LINKS */\r\n"
					  		+ "        a[x-apple-data-detectors] {\r\n"
					  		+ "            color: inherit !important;\r\n"
					  		+ "            text-decoration: none !important;\r\n"
					  		+ "            font-size: inherit !important;\r\n"
					  		+ "            font-family: inherit !important;\r\n"
					  		+ "            font-weight: inherit !important;\r\n"
					  		+ "            line-height: inherit !important;\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        /* MOBILE STYLES */\r\n"
					  		+ "        @media screen and (max-width:600px) {\r\n"
					  		+ "            h1 {\r\n"
					  		+ "                font-size: 32px !important;\r\n"
					  		+ "                line-height: 32px !important;\r\n"
					  		+ "            }\r\n"
					  		+ "        }\r\n"
					  		+ "\r\n"
					  		+ "        /* ANDROID CENTER FIX */\r\n"
					  		+ "        div[style*=\"margin: 16px 0;\"] {\r\n"
					  		+ "            margin: 0 !important;\r\n"
					  		+ "        }\r\n"
					  		+ "    </style>\r\n"
					  		+ "</head>\r\n"
					  		+ "\r\n"
					  		+ "<body style=\"background-color: #ec3361; margin: 0 !important; padding: 0 !important;\">\r\n"
					  		+ "    <!-- HIDDEN PREHEADER TEXT -->\r\n"
					  		+ "    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>\r\n"
					  		+ "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
					  		+ "        <!-- LOGO -->\r\n"
					  		+ "        <tr>\r\n"
					  		+ "            <td bgcolor=\"#ec3361\" align=\"center\">\r\n"
					  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
					  		+ "                    <tr>\r\n"
					  		+ "                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\r\n"
					  		+ "                    </tr>\r\n"
					  		+ "                </table>\r\n"
					  		+ "            </td>\r\n"
					  		+ "        </tr>\r\n"
					  		+ "        <tr>\r\n"
					  		+ "            <td bgcolor=\"#ec3361\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n"
					  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
					  		+ "                    <tr>\r\n"
					  		+ "                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\r\n"
					  		+ "                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Welcome!</h1> <img src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" />\r\n"
					  		+ "                        </td>\r\n"
					  		+ "                    </tr>\r\n"
					  		+ "                </table>\r\n"
					  		+ "            </td>\r\n"
					  		+ "        </tr>\r\n"
					  		+ "        <tr>\r\n"
					  		+ "            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n"
					  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
					  		+ "                    <tr>\r\n"
					  		+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\r\n"
					  		+ "                            <p style=\"margin: 0;\">your verification token has expired.</p>\r\n"
					  		+ "                        </td>\r\n"
					  		+ "                    </tr>\r\n"
					  		+ "                \r\n"
					  		+ "                </table>\r\n"
					  		+ "            </td>\r\n"
					  		+ "        </tr>\r\n"
					  		+ "    </table>\r\n"
					  		+ "</body>\r\n"
					  		+ "\r\n"
					  		+ "</html>";
			  }else {
				  // the token is valid 
				  // activate the user account 
				  user.setEnabled(true);
				  //update the user
				  userRepository.save(user);
				 // model.addAttribute("message", "votre compte est activé" );
				 // File file = ResourceUtils.getFile("classpath:active.txt");
				 // String content = new String(Files.readAllBytes(file.toPath()));
				 // System.out.println(content);
			  }
		  }else {
			  //the user account is already activated
			  model.addAttribute("message", "already activated");
		  }
	  }
	  //add '/activation' to SecurityConfighttps://bbbootstrap.com/snippets/confirm-account-email-template-17848137
	  return "<!DOCTYPE html>\r\n"
	  		+ "<html>\r\n"
	  		+ "\r\n"
	  		+ "<head>\r\n"
	  		+ "    <title></title>\r\n"
	  		+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n"
	  		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
	  		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
	  		+ "    <style type=\"text/css\">\r\n"
	  		+ "        @media screen {\r\n"
	  		+ "            @font-face {\r\n"
	  		+ "                font-family: 'Lato';\r\n"
	  		+ "                font-style: normal;\r\n"
	  		+ "                font-weight: 400;\r\n"
	  		+ "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\r\n"
	  		+ "            }\r\n"
	  		+ "\r\n"
	  		+ "            @font-face {\r\n"
	  		+ "                font-family: 'Lato';\r\n"
	  		+ "                font-style: normal;\r\n"
	  		+ "                font-weight: 700;\r\n"
	  		+ "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\r\n"
	  		+ "            }\r\n"
	  		+ "\r\n"
	  		+ "            @font-face {\r\n"
	  		+ "                font-family: 'Lato';\r\n"
	  		+ "                font-style: italic;\r\n"
	  		+ "                font-weight: 400;\r\n"
	  		+ "                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\r\n"
	  		+ "            }\r\n"
	  		+ "\r\n"
	  		+ "            @font-face {\r\n"
	  		+ "                font-family: 'Lato';\r\n"
	  		+ "                font-style: italic;\r\n"
	  		+ "                font-weight: 700;\r\n"
	  		+ "                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\r\n"
	  		+ "            }\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        /* CLIENT-SPECIFIC STYLES */\r\n"
	  		+ "        body,\r\n"
	  		+ "        table,\r\n"
	  		+ "        td,\r\n"
	  		+ "        a {\r\n"
	  		+ "            -webkit-text-size-adjust: 100%;\r\n"
	  		+ "            -ms-text-size-adjust: 100%;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        table,\r\n"
	  		+ "        td {\r\n"
	  		+ "            mso-table-lspace: 0pt;\r\n"
	  		+ "            mso-table-rspace: 0pt;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        img {\r\n"
	  		+ "            -ms-interpolation-mode: bicubic;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        /* RESET STYLES */\r\n"
	  		+ "        img {\r\n"
	  		+ "            border: 0;\r\n"
	  		+ "            height: auto;\r\n"
	  		+ "            line-height: 100%;\r\n"
	  		+ "            outline: none;\r\n"
	  		+ "            text-decoration: none;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        table {\r\n"
	  		+ "            border-collapse: collapse !important;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        body {\r\n"
	  		+ "            height: 100% !important;\r\n"
	  		+ "            margin: 0 !important;\r\n"
	  		+ "            padding: 0 !important;\r\n"
	  		+ "            width: 100% !important;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        /* iOS BLUE LINKS */\r\n"
	  		+ "        a[x-apple-data-detectors] {\r\n"
	  		+ "            color: inherit !important;\r\n"
	  		+ "            text-decoration: none !important;\r\n"
	  		+ "            font-size: inherit !important;\r\n"
	  		+ "            font-family: inherit !important;\r\n"
	  		+ "            font-weight: inherit !important;\r\n"
	  		+ "            line-height: inherit !important;\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        /* MOBILE STYLES */\r\n"
	  		+ "        @media screen and (max-width:600px) {\r\n"
	  		+ "            h1 {\r\n"
	  		+ "                font-size: 32px !important;\r\n"
	  		+ "                line-height: 32px !important;\r\n"
	  		+ "            }\r\n"
	  		+ "        }\r\n"
	  		+ "\r\n"
	  		+ "        /* ANDROID CENTER FIX */\r\n"
	  		+ "        div[style*=\"margin: 16px 0;\"] {\r\n"
	  		+ "            margin: 0 !important;\r\n"
	  		+ "        }\r\n"
	  		+ "    </style>\r\n"
	  		+ "</head>\r\n"
	  		+ "\r\n"
	  		+ "<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\r\n"
	  		+ "    <!-- HIDDEN PREHEADER TEXT -->\r\n"
	  		+ "    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>\r\n"
	  		+ "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
	  		+ "        <!-- LOGO -->\r\n"
	  		+ "        <tr>\r\n"
	  		+ "            <td bgcolor=\"#ec3361\" align=\"center\">\r\n"
	  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	  		+ "                    <tr>\r\n"
	  		+ "                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\r\n"
	  		+ "                    </tr>\r\n"
	  		+ "                </table>\r\n"
	  		+ "            </td>\r\n"
	  		+ "        </tr>\r\n"
	  		+ "        <tr>\r\n"
	  		+ "            <td bgcolor=\"#ec3361\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n"
	  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	  		+ "                    <tr>\r\n"
	  		+ "                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\r\n"
	  		+ "                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Bienvenue!</h1> <img src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" />\r\n"
	  		+ "                        </td>\r\n"
	  		+ "                    </tr>\r\n"
	  		+ "                </table>\r\n"
	  		+ "            </td>\r\n"
	  		+ "        </tr>\r\n"
	  		+ "        <tr>\r\n"
	  		+ "            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n"
	  		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n"
	  		+ "                    <tr>\r\n"
	  		+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\r\n"
	  		+ "                            <p style=\"margin: 0;\">Nous sommes ravis que vous commenciez. Tout d'abord, votre compte est activé avec succès. Appuyez simplement sur le bouton ci-dessous pour vous connecter.</p>\r\n"
	  		+ "                        </td>\r\n"
	  		+ "                    </tr>\r\n"
	  		+ "                    <tr>\r\n"
	  		+ "                        <td bgcolor=\"#ffffff\" align=\"left\">\r\n"
	  		+ "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
	  		+ "                                <tr>\r\n"
	  		+ "                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\r\n"
	  		+ "                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
	  		+ "                                            <tr>\r\n"
	  		+ "                                                <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#ec3361\"><a href=\"http://localhost:4200/login\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #ec3361; display: inline-block;\">Se connecter</a></td>\r\n"
	  		+ "                                            </tr>\r\n"
	  		+ "                                        </table>\r\n"
	  		+ "                                    </td>\r\n"
	  		+ "                                </tr>\r\n"
	  		+ "                            </table>\r\n"
	  		+ "                        </td>\r\n"
	  		+ "                    </tr> <!-- COPY -->\r\n"
	  		+ "                \r\n"
	  		+ "                </table>\r\n"
	  		+ "            </td>\r\n"
	  		+ "        </tr>\r\n"
	  		+ "    </table>\r\n"
	  		+ "</body>\r\n"
	  		+ "\r\n"
	  		+ "</html>";
  }

  
  @PostMapping("/login")
  public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
    System.out.println("******************************0");

      return authService.login(loginRequest);
  }



  


  
  
  
// @GetMapping("/all")
// public ResponseEntity<List<User>> getAllUsers(){
//   List<User> users = authService.findAllUsers();
//   return new ResponseEntity<>(users, HttpStatus.OK);
//  }
//  
 
//  @GetMapping("/find/{id}")
//  public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
//User user = userRepository.findUserById(id); 
//return new ResponseEntity<>(user, HttpStatus.OK);
//  }

  
  ////////////////////
  
  //get tous les candidates 
  
  @GetMapping("/users")
  public List<User> getAllUsers(){
    
    return userRepository.findAll();
  }
  
 
  
  //get Candidate byID
  
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id){
    User user = userRepository.findUserById(id)
  .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :"+ id));
    return ResponseEntity.ok(user);
  }
  
  


  @Autowired
  Environment environment;
  
 

  @GetMapping("/user/current")
  public ResponseEntity<String[]> getCurrentActiveProfiles() {
    System.out.println(Arrays.asList(environment.getActiveProfiles()));
    return ResponseEntity.ok(environment.getActiveProfiles());
  }

  
  
  @PutMapping("/valideCompte/{id}")
  public ResponseEntity<User> ValiderRec(@PathVariable("id") Long id ,@RequestBody User user ){
   Optional<User>c=userRepository.findById(id);
   c.equals(user);
   user.setEtat("valide");
   userRepository.save(user);
 
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }



@PutMapping("/refuserCompte/{id}")
public ResponseEntity<User> RefuserCompte(@PathVariable("id") Long id ,@RequestBody User user ){
 Optional<User>c=userRepository.findById(id);
 c.equals(user);
 user.setEtat("invalide");
 userRepository.save(user);

   return new ResponseEntity<>(user, HttpStatus.CREATED);
}




@PutMapping("/updateUser/{id}")
public ResponseEntity<User> updateCandidate(@PathVariable("id") Long id ,@RequestBody User candidateDetails ){ 
 User candidate =userRepository.findById(id)
     .orElseThrow(() -> new ResourceNotFoundException("Candidate not exist with id :"+ id));

 candidate.equals(candidateDetails);
 System.out.println(candidateDetails.getId());
 System.out.println(candidate.getId());

 candidate.setCinCand(candidateDetails.getCinCand());
 candidate.setNomCand(candidateDetails.getNomCand());
 candidate.setPrenomCand(candidateDetails.getPrenomCand());
 candidate.setEmailCand(candidateDetails.getEmailCand());
 candidate.setTelephoneCand(candidateDetails.getTelephoneCand());
 candidate.setAdresseCand(candidateDetails.getAdresseCand());
 candidate.setVilleCand(candidateDetails.getVilleCand());
 candidate.setPaysCand(candidateDetails.getPaysCand());
 candidate.setCertificationCand(candidateDetails.getCertificationCand());
 candidate.setStageCand(candidateDetails.getStageCand());
 candidate.setSocieteStaCand(candidateDetails.getSocieteStaCand());
 candidate.setSocieteProCand(candidateDetails.getSocieteProCand());
 candidate.setDureeProCand(candidateDetails.getDureeProCand());
 candidate.setApropos(candidateDetails.getApropos());
 
 List<ParcoursUniv> cursusListe= new ArrayList();
 //transient
 candidateDetails.getCursus().forEach(cursus -> {
   //pour recuper l user
   cursus.setUser(candidate);
   cursusListe.add(cursus);
   });
 candidate.setCursus(cursusListe);
 
//manque les files
userRepository.save(candidate);
return new ResponseEntity<>(candidate, HttpStatus.CREATED);
}






@PutMapping("/updateUserOriginal/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") Long id ,@RequestBody User UserDetails ){
 
 
 User user =userRepository.findById(id)
     .orElseThrow(() -> new ResourceNotFoundException("Candidate not exist with id :"+ id));

 user.equals(UserDetails);
 
 user.setImageUrl(UserDetails.getImageUrl());
 user.setUsername(UserDetails.getUsername());
 user.setEmail(UserDetails.getEmail());
 user.setTelephone(UserDetails.getTelephone());
 user.setAdresse(UserDetails.getAdresse());
 user.setPoste(UserDetails.getPoste());
 user.setExperience(UserDetails.getExperience());
 user.setPassword(UserDetails.getPassword());
 user.setPays(UserDetails.getPays());
user.setPays(UserDetails.getVilleCand());

 
userRepository.save(user);
return new ResponseEntity<>(user, HttpStatus.CREATED);
}



@GetMapping("/users/{id}/cursus")
public List< ParcoursUniv > getCursusByUser(@PathVariable(value = "id") Long userId) {
    return parcoursRepo.findByUserId(userId);
}






















//
//@PostMapping(value = "/updatePassword/{id}")
//public ResponseEntity<?> updatePassword(@RequestBody User user) throws Exception {
//   authService.updatePassword(user.getId(), user.getPassword());
// 
//   return new ResponseEntity<>(new CustomResponse(CustomResponse.APIV, 201, true, "Password updated successfully"), HttpStatus.OK);
//}









  
  
//  @PostMapping("/can/{id}")
//  public ResponseEntity<Candidate> CandiMe(@PathVariable("id") Long id, @RequestBody User user, Candidate candidate){
//    if(user.getEtat()=="valide") {
//      
//       Candidate can = new Candidate();
//
//     String  emailUser = user.getEmail();
//       
//      can.setEmail(emailUser);
//    //  can.setEmail(user.getEmail());
//      
//      Long idUser= user.getId();
//      can.setId(idUser);
//      
//      candRepo.save(can);
//    }
//    
//    return new ResponseEntity<>(candidate, HttpStatus.CREATED);
//  }
//  
//  


//  private Candidate cand;
//
//  @GetMapping("/candidateNew")
//  public ResponseEntity<User> IsCand(@PathVariable("id") Long id ,@RequestBody User user ){
//  
//
//    Candidate cand = new Candidate(); 
//   if(user.getEtat() == "valide") {
//   
//
//    cand.setEmail(user.getEmail());
//    candRepo.save(cand);
//
//    }
//    return new ResponseEntity<>(user, HttpStatus.CREATED);
//  }
//



//  @GetMapping("/candidateNew")
//  public ResponseEntity<Candidate> IsCand(@PathVariable("id") Long id ,@RequestBody User user ){
//
//
//    
//
//   if(user.getEtat() == "valide") {
//   Candidate candidate = new Candidate();
//   
//   
//     candidate.setEmail(user.getEmail());
//     candidate.setNom(user.getUserName());
//   candidate.setCin(user.getId());
//
//    Candidate updatedCandidate = candRepo.save(candidate);
//return new ResponseEntity<Candidate>(updatedCandidate, HttpStatus.CREATED);
//     
//    }
//  return null;
// }
//

  
  
//  @PostMapping("/login")
//  public String Login(@RequestBody LoginRequest loginRequest) {
//    return authService.login(loginRequest);
//  }
  
  
  
}
