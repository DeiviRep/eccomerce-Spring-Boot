package com.jalasoft.ecommerce.repository;

import com.jalasoft.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
  Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}
