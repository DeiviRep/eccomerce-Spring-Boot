package com.jalasoft.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private Boolean enable;
  private String roleName;
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  private UUID roleId;
}
