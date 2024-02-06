package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
  List<Category> getAll();

  Category getById(UUID id);

  Category save(Category category);
}
