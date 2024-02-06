package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.OrderDto;
import java.util.UUID;

public interface OrderService {

  String save(OrderDto orderDto);

  OrderDto getById(UUID id);
}
