package com.jalasoft.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Data
@Table(name="roles")
public class Role {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  private String name;
  private String description;
}

