package com.jalasoft.ecommerce.security;

import com.jalasoft.ecommerce.security.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

  private JwtAuthenticationFilter jwtAuthenticationFilter;
  private static final String[] SWAGGER_WHITELIST = {
      "/v3/api-docs/**",
      "/swagger-ui/**",
      "/swagger-ui.html",
      "/swagger-resources/**",
      "/webjars/**",
      "/configuration/**",
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable);
    http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.authorizeHttpRequests(
        auth -> {
          auth.requestMatchers(SWAGGER_WHITELIST).permitAll()
              .requestMatchers("/auth/**").permitAll()
              .requestMatchers(HttpMethod.GET, "/categories/**").permitAll()
              .requestMatchers(HttpMethod.POST, "/products").hasAuthority("ADMIN")
              .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
              .requestMatchers(HttpMethod.POST,"/orders").hasAuthority("USER")
              .requestMatchers(HttpMethod.GET, "/orders/**").hasAuthority("USER")
              .requestMatchers(HttpMethod.GET, "/users/**").hasAuthority("ADMIN")
              .anyRequest().authenticated();
        }
    );
    //TODO: el orden de los filtros son importantes, por eso acomodamos, que añada nuestro filtor jwt, y sea el primer filtro que verifique
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
