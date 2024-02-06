package com.jalasoft.ecommerce.mapper;

import com.jalasoft.ecommerce.dto.PageDto;
import com.jalasoft.ecommerce.dto.ProductDto;
import com.jalasoft.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
  public PageDto<Product> fromEntity(Page<Product> page){
    PageDto<Product> pageDto = new PageDto<>();
    pageDto.setContent(page.getContent());
    pageDto.setPageNumber(page.getNumber());
    pageDto.setPageSize(page.getSize());
    pageDto.setLast(page.isLast());
    pageDto.setTotalPages(page.getTotalPages());
    pageDto.setTotalElements(page.getTotalElements());
    return pageDto;
  }

  public Product fromDto(ProductDto dto){
    Product product = new Product();
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());
    product.setActive(dto.getActive());
    product.setImageUrl(dto.getImageUrl());
    return product;
  }

  public ProductDto fromProduct(Product product){
    ProductDto productDto = new ProductDto();
    productDto.setName(product.getName());
    productDto.setDescription(product.getDescription());
    productDto.setActive(product.getActive());
    productDto.setCategoryId(product.getCategory().getId());
    return productDto;
  }

}
