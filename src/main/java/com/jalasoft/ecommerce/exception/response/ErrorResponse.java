package com.jalasoft.ecommerce.exception.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Getter
@Setter
@Builder
public class ErrorResponse {

  private int code;
  private String error;
  private String message;

}
