package com.jalasoft.ecommerce.mapper;

import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User fromDto(UserDto dto){
    User user = new User();
    user.setFirstName(dto.getFirstName());
    user.setLastName(dto.getLastName());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    return  user;
  }

  public UserDto fromUser (User user){
    UserDto userDto = new UserDto();
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setAddress(user.getAddress());
    userDto.setEmail(user.getEmail());
    userDto.setRoleName(user.getRole().getName());
    userDto.setEnable(user.getEnable());
    return  userDto;
  }
}
