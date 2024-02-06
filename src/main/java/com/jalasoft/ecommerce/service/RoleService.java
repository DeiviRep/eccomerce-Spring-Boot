package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.Role;
import java.util.UUID;

public interface RoleService {
  Role getByName(String name);

  Role getById(UUID id);

  Role save(Role role);
}
