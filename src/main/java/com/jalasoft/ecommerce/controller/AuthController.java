package com.jalasoft.ecommerce.controller;

import com.jalasoft.ecommerce.dto.AuthenticationRequest;
import com.jalasoft.ecommerce.dto.AuthenticationResponse;
import com.jalasoft.ecommerce.dto.EmailNotification;
import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.service.AuthenticationService;
import com.jalasoft.ecommerce.service.EmailService;
import com.jalasoft.ecommerce.service.RegistrationService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

  private RegistrationService registrationService;
  private EmailService emailService;
  private AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody UserDto userDto) {
    String message = registrationService.register(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody @Valid AuthenticationRequest request) {
    System.out.println("hello: " + request.getEmail() + "pass" + request.getPassword());
    AuthenticationResponse response = authenticationService.authenticate(request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @Hidden
  @PostMapping("/email")
  public String sendEmail() {
    EmailNotification email = EmailNotification.builder().to("pelisplus71@gmail.com")
        .subject("TEST")
        .body("Mensaje con Text plano").hasTemplate(false).build();

    EmailNotification email2 = EmailNotification.builder().to("pelisplus71@gmail.com")
        .subject("TEST")
        .body("<h1>templete</h1>").hasTemplate(true).build();

    emailService.send(email);
    emailService.send(email2);
    return "Messages sent successfully";
  }

  @GetMapping("/confirm")
  public ResponseEntity<String> confirm(@RequestParam String token) {
    String message = registrationService.confirm(token);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }
}
