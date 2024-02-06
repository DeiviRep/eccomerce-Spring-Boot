package com.jalasoft.ecommerce.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PageDto<T> {

  private List<T> content;
  private boolean last;
  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private long totalElements;
}
