package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.AuthenticationRequest;
import com.jalasoft.ecommerce.dto.AuthenticationResponse;
import com.jalasoft.ecommerce.entity.User;
import com.jalasoft.ecommerce.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

  private AuthenticationManager authenticationManager;
  private JwtService jwtService;

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println("helo 2: " + request);
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
        request.getEmail(), request.getPassword());
    System.out.println("helo 3: " + auth);
    Authentication authResponser = authenticationManager.authenticate(auth);
    System.out.println("helo 4: " + authResponser);
    User user = (User) authResponser.getPrincipal();
    String accessToken = jwtService.create(user);
    System.out.println("helo 5: " + accessToken);
    return AuthenticationResponse.builder().accessToken(accessToken).build();
  }
}
