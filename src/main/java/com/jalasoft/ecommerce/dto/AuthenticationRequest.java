package com.jalasoft.ecommerce.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthenticationRequest {
  @Email
  private String email;
  private String password;

}
