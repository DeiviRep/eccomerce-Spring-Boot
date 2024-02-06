package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.entity.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  UserDto getById(UUID id);

  boolean existByEmail(String email);

  User save(User user);

  UserDto update(UUID id, UserDto userDto);

  List<UserDto> getAll();

  void enableUser(User user);

  User findById(UUID id);
}
