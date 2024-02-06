package com.jalasoft.ecommerce.controller;

import com.jalasoft.ecommerce.entity.Category;
import com.jalasoft.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "Category",
    description = "Operations about categories"
)
@AllArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

  private CategoryService categoryService;

  @Operation(
      summary = "Get all categories",
      description = "Get all categories"
  )
  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = categoryService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(categories);
  }

  @Operation(
      summary = "Get a category by id",
      description = "Get a category by id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Category found",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Category.class)
              )
          ),
          @ApiResponse(
              responseCode = "404",
              description = "Category not found",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResponse.class)
              )
          )
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(
      @Parameter(
          required = true,
          description = "Category id"
      )
      @PathVariable UUID id) {
    Category result = categoryService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {
    Category categorySave = categoryService.save(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(categorySave);
  }
}
