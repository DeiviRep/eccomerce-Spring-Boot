package com.jalasoft.ecommerce.service;

import com.jalasoft.ecommerce.dto.EmailNotification;
import com.jalasoft.ecommerce.dto.UserDto;
import com.jalasoft.ecommerce.entity.ConfirmationToken;
import com.jalasoft.ecommerce.entity.Role;
import com.jalasoft.ecommerce.entity.User;
import com.jalasoft.ecommerce.exception.EmailAlreadyTaken;
import com.jalasoft.ecommerce.util.TemplateGenerator;
import com.jalasoft.ecommerce.util.UrlGenerator;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private UserService userService;
  private RoleService roleService;
  private ConfirmationTokenService confirmationTokenService;
  private EmailService emailService;
  private PasswordEncoder passwordEncoder;

  public String register(UserDto userDto) {
    boolean existsEmail = userService.existByEmail(userDto.getEmail());
    if (existsEmail) {
      throw new EmailAlreadyTaken(userDto.getEmail());
    }

    Role role = roleService.getByName(userDto.getRoleName());
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setAddress(userDto.getAddress());
    user.setEmail(userDto.getEmail());
    String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
    user.setPassword(encryptedPassword);
    user.setRole(role);

    User userSaved = userService.save(user);

    String token = UUID.randomUUID().toString();

    confirmationTokenService.save(
        new ConfirmationToken(
            token,
            LocalDateTime.now().plusMinutes(15),
            userSaved
        ));
    // TODO: Send email with confirmation token // CREDENTIALS: -u pelisplus71@gmail.com -p bomi ltip luuc qvvb
    String url = UrlGenerator.create("/auth/confirm", "token", token);
    String template = TemplateGenerator.generateTemplateConfirmationToken(userSaved.getFirstName(),
        url);
    EmailNotification email = EmailNotification.builder().to(userSaved.getEmail())
        .subject("Account Confirmation").body(template).hasTemplate(true).build();
    emailService.send(email);
    return "User registered successfully with id: " + userSaved.getId();
  }

  public String confirm(String token) {
    ConfirmationToken confirmationToken = confirmationTokenService.getByToken(token);
    if (confirmationToken.getConfirmedAt() != null) {
    throw new RuntimeException("Token is already confirm");
    }
    if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())){
      throw new RuntimeException("Token expired");
    }
    userService.enableUser(confirmationToken.getUser());
    confirmationTokenService.setConfirmedAt(confirmationToken);
    return "Account confirmed successfully";
  }

}
