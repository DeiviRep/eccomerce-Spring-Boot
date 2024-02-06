package com.jalasoft.ecommerce.repository;

import com.jalasoft.ecommerce.entity.ConfirmationToken;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, UUID> {

  Optional<ConfirmationToken> findByToken(String token);
}
