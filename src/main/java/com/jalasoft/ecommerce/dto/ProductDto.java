package com.jalasoft.ecommerce.dto;

import com.jalasoft.ecommerce.entity.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

  @NotBlank(message = "Name can not be blank")
  @Size(min = 3, max = 70, message = "Size can be between 3 and 70")
  private String name;
  @NotBlank(message = "Name can not be blank")
  private String description;
  @URL
  //TODO: notaciones regex o expresiones regulares
  @Pattern(regexp = "https")
  private String imageUrl;
  @DecimalMin(value = "0.0", inclusive = false, message = "Decimal can not be negative")
  private Double price;
  @Min(value = 0, message = "Price can not be negative")
  private Integer stock;
  @NotNull
  private Boolean active;
  @NotNull
  private UUID categoryId;
  @NotNull
  private Category category;
}
