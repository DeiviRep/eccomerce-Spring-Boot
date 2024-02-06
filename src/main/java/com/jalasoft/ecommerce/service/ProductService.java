package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.PageDto;
import com.jalasoft.ecommerce.dto.ProductDto;
import com.jalasoft.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  Product save(ProductDto product);

  ProductDto update(UUID id, ProductDto product);

  Product getById(UUID id);

  PageDto<Product> getProduct(Pageable pageable);

  PageDto<Product> getProductFiltered(Double minPrice, Double maxPrice, Pageable pageable);
}
