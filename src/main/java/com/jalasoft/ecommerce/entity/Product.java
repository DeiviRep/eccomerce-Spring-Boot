package com.jalasoft.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

@Data
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  @Column(length = 50, nullable = false)
  private String name;
  private String description;
  private String imageUrl;
  private Double price;
  private Integer stock;
  private Boolean active;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
}
