package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.EmailNotification;

public interface EmailService {
  void send(EmailNotification emailNotification);

}
