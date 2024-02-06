package com.jalasoft.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.jalasoft.ecommerce.entity.OrderItem;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto {
  private String comment;
  @JsonProperty(access = Access.READ_ONLY)
  private double totalPrice;
  List<OrderItemDto> items;
}
