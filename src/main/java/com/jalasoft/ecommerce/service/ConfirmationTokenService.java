package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.ConfirmationToken;

public interface ConfirmationTokenService {

  void save(ConfirmationToken confirmationToken);

  ConfirmationToken getByToken(String token);

  void setConfirmedAt(ConfirmationToken confirmationToken);
}
