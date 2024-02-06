package com.jalasoft.ecommerce.controller;

import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.entity.User;
import com.jalasoft.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDto>> getAll() {
    List<UserDto> userList = userService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(userList);
  }

  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
    UserDto userFound = userService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(userFound);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDto> update(@PathVariable UUID id, @RequestBody UserDto dto) {
    UserDto userDto = userService.update(id, dto);
    return ResponseEntity.status(HttpStatus.OK).body(userDto);
  }
}
