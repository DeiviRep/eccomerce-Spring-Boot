package com.jalasoft.ecommerce.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UrlGenerator {
  public static String create(String path, String queryName, String queryValue) {
    //capture el dominio -> ServletUriComponentsBuilder
    return ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path(path)
        .queryParam(queryName,queryValue)
        .build()
        .toUriString();
  }

}
