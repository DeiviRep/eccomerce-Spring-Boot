package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.PageDto;
import com.jalasoft.ecommerce.dto.ProductDto;
import com.jalasoft.ecommerce.entity.Category;
import com.jalasoft.ecommerce.entity.Product;
import com.jalasoft.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import com.jalasoft.ecommerce.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryService categoryService;
  private ProductMapper productMapper;

  @Override
  public Product save(ProductDto dto) {
    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);
    return productRepository.save(product);
  }

  @Override
  public ProductDto update(UUID id, ProductDto dto) {
    Product product = productRepository.getById(id);
    product.setActive(dto.getActive());
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    if (dto.getCategoryId() != null){
      Category category = categoryService.getById(dto.getCategoryId());
      product.setCategory(category);
    }

    Product productSaved = productRepository.save(product);
    return productMapper.fromProduct(productSaved);
  }

  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }

  @Override
  public PageDto<Product> getProduct(Pageable pageable) {
    Page<Product> page = productRepository.findAll(pageable);
    return productMapper.fromEntity(page);
  }

  @Override
  public PageDto<Product> getProductFiltered(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.fromEntity(page);
  }
}
