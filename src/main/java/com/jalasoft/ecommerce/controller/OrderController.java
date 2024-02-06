package com.jalasoft.ecommerce.controller;

import com.jalasoft.ecommerce.dto.OrderDto;
import com.jalasoft.ecommerce.repository.OrderRepository;
import com.jalasoft.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("orders")
@SecurityRequirement(
    name = "bearerAuth"
)
public class OrderController {

  private OrderService orderService;
  private OrderRepository orderRepository;

  @PostMapping
  private ResponseEntity<String> save(@RequestBody OrderDto orderDto) {
    String message = orderService.save(orderDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @GetMapping("/{id}/price/total")
  public String getTotalPrice(@PathVariable UUID id) {
    //query native
    double total = orderRepository.getTotalPriceByOrderId(id.toString());
    //jpql
    double total2 = orderRepository.getTotalPrice(id);

    return "Query Native " + total + "JPQL " + total2;
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getById(@PathVariable UUID id) {
    OrderDto orderDto = orderService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(orderDto);
  }
}

