package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.Category;
import com.jalasoft.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(UUID id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found"));
  }

  @Override
  public Category save(Category category) {
    return categoryRepository.save(category);
  }
}
