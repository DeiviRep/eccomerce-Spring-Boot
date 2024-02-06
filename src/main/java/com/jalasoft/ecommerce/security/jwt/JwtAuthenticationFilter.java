package com.jalasoft.ecommerce.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private AuthenticationManager authenticationManager;
  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain
  ) throws ServletException, IOException {
    String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    //TODO: de esta forma llegara desde el heade el token :: "Bearer iuqwiuiw.qwkqwioqw.qpowoiqioqw"
    if (authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }
    String token = authHeader.substring(7);

    JwtAuthenticationToken auth = new JwtAuthenticationToken(token);
    Authentication authResult = authenticationManager.authenticate(auth);
    SecurityContext context = SecurityContextHolder.getContext();
    context.setAuthentication(authResult);

    SecurityContextHolder.setContext(context);

    filterChain.doFilter(request,response);
  }
}
