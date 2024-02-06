package com.jalasoft.ecommerce;

import com.jalasoft.ecommerce.entity.Category;
import com.jalasoft.ecommerce.entity.Product;
import com.jalasoft.ecommerce.entity.Role;
import com.jalasoft.ecommerce.repository.CategoryRepository;
import com.jalasoft.ecommerce.repository.ProductRepository;
import com.jalasoft.ecommerce.repository.RoleRepository;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CursoDeJavaYSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(CursoDeJavaYSpringBootApplication.class, args);
  }

  /*@Bean
  public CommandLineRunner setData(CategoryRepository categoryRepository,
      ProductRepository productRepository, RoleRepository roleRepository) {
    return arg -> {
      Category category = new Category();
      category.setName("TRAVEL");
      category.setDescription("Mochila for travel");

      Product product = new Product();
      product.setName("mochila");
      product.setDescription("mochila de viaje");
      product.setPrice(20.0);
      product.setStock(1999);
      product.setActive(true);
      product.setImageUrl("###");
      product.setCategory(category);

      categoryRepository.save(category);
      productRepository.save(product);

      Role role = new Role();
      role.setName("USER");
      role.setDescription("This is a description");

      Role role2 = new Role();
      role2.setName("USER2");
      role2.setDescription("This is a description");

      roleRepository.save(role);
      roleRepository.save(role2);
    };
  }
*/
}
