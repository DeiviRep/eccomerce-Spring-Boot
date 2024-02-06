package com.jalasoft.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

// - IN DECORATOR LOMBOK -
@NoArgsConstructor // decorator equiv a
//  public Category(){
//  }
@AllArgsConstructor // decorator equiv a
//  public Category(Long id, String name, String description) {
//    this.id = id;
//    this.name = name;
//    this.description = description;
//  }
@Getter // decorator equiv a
//public Long getId() {
//    return id;
//  }
@Setter // decorator equiv a
//  public void setId(Long id) {
//    this.id = id;
//  }
// - OUT DECORATOR LOMBOK -
@EqualsAndHashCode // decorator equiv a
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    Category category = (Category) o;
//    return Objects.equals(id, category.id) && Objects.equals(name, category.name)
//        && Objects.equals(description, category.description);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name, description);
//  }
@Data // decorator equiv a
// @EqualsAndHashCode - @NoArgsConstructor - @AllArgsConstructor - @Getter - @Setter
@Entity
@Table(name="categories")
public class Category {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  @Column(nullable = false, length = 30)
  private String name;
  private String description;

}
