package com.jalasoft.ecommerce.exception.response;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationErrorResponse {
  private int code;
  private String error;
  private List<FieldErrorModel> errors;

}
