package com.jalasoft.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class EmailNotification {

  String to;
  String subject;
  String body;
  boolean hasTemplate;
}
