package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.OrderDto;
import com.jalasoft.ecommerce.dto.OrderItemDto;
import com.jalasoft.ecommerce.entity.Order;
import com.jalasoft.ecommerce.entity.OrderItem;
import com.jalasoft.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;
  private ProductService productService;

  @Override
  public String save(OrderDto orderDto) {
    Order order = new Order();
    order.setComment(orderDto.getComment());
    List<OrderItem> orderItemList = orderDto.getItems().stream().map(item -> {
      OrderItem orderItem = new OrderItem();
      orderItem.setOrder(order);
      orderItem.setQuantity(item.getQuantity());
      orderItem.setProduct(productService.getById(item.getProductId()));
      return orderItem;
    }).toList();

    order.setItems(orderItemList);

    Order orderSaved = orderRepository.save(order);
    return "Order saved successfully with id: " + orderSaved.getId();
  }

  @Override
  public OrderDto getById(UUID id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    OrderDto orderDto = new OrderDto();
    orderDto.setComment(order.getComment());

    List<OrderItemDto> itemsDto = order.getItems().stream().map(orderItem -> {
      OrderItemDto itemDto = new OrderItemDto();
      itemDto.setQuantity(orderItem.getQuantity());
      itemDto.setProductId(orderItem.getProduct().getId());
      return itemDto;
    }).toList();

    orderDto.setItems(itemsDto);
    orderDto.setTotalPrice(orderRepository.getTotalPrice(id));

    return orderDto;
  }
}
