package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.Role;
import com.jalasoft.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public Role getById(UUID id) {
    return roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Not found recurse"));
  }

  @Override
  public Role save(Role role) {
    return roleRepository.save(role);
  }
}
