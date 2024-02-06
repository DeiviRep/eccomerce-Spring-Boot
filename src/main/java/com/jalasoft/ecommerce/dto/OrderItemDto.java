package com.jalasoft.ecommerce.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderItemDto {

  private Integer quantity;
  private UUID productId;
}
