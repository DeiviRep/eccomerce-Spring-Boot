package com.jalasoft.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

@Data
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  @Column(nullable = false)
  private LocalDateTime date = LocalDateTime.now();
  private String comment;
  @Enumerated(value = EnumType.STRING)
  private OrderState state = OrderState.PENDING;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  // la notacion cascade persistira en guardar los items sin necesidad de llamar a un repositori
  @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
  List<OrderItem> items;

}
