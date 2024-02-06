package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.entity.ConfirmationToken;
import com.jalasoft.ecommerce.repository.ConfirmationTokenRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl  implements ConfirmationTokenService{

  private ConfirmationTokenRepository confirmationTokenRepository;

  @Override
  public void save(ConfirmationToken confirmationToken) {
    confirmationTokenRepository.save(confirmationToken);
  }

  @Override
  public ConfirmationToken getByToken(String token) {
    return confirmationTokenRepository.findByToken(token).orElseThrow(()-> new EntityNotFoundException("Recurse not found"));
  }

  @Override
  public void setConfirmedAt(ConfirmationToken confirmationToken) {
    confirmationToken.setConfirmedAt(LocalDateTime.now());
    confirmationTokenRepository.save(confirmationToken);
  }
}
