package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.entity.Role;
import com.jalasoft.ecommerce.entity.User;
import com.jalasoft.ecommerce.mapper.UserMapper;
import com.jalasoft.ecommerce.repository.RoleRepository;
import com.jalasoft.ecommerce.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private UserMapper mapper;

  @Override
  public UserDto getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));
    UserDto userDto = mapper.fromUser(user);
    return userDto;
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public UserDto update(UUID id, UserDto dto) {

    User userFound = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));

    userFound.setFirstName(dto.getFirstName());
    userFound.setLastName(dto.getLastName());
    userFound.setEmail(dto.getEmail());
    userFound.setPassword(dto.getPassword());
    userFound.setRole(userFound.getRole());

    User userSaved = userRepository.save(userFound);
    UserDto userDto = mapper.fromUser(userSaved);
    return userDto;
  }

  @Override
  public List<UserDto> getAll() {
    List<User> users = userRepository.findAll();
    List<UserDto> usersDtoList = new ArrayList<>();
    for (User user : users) {
      UserDto userDto = mapper.fromUser(user);
      usersDtoList.add(userDto);
    }

    return usersDtoList;
  }

  @Override
  public void enableUser(User user) {
    user.setEnable(true);
    userRepository.save(user);
  }

  @Override
  public User findById(UUID id) {
    return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
  }
}
