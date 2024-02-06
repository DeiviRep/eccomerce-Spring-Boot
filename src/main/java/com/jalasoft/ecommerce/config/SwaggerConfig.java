package com.jalasoft.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;







@OpenAPIDefinition(
    info = @Info(
        title = "E-commerce API",
        description = "Backend E-commerce API",
        //termsOfServiceUrl = "https://github.com/Jalasoft/e-commerce",
        contact = @Contact(
            name = "Base Backend",
            url = "https://github.com/Jalasoft/e-commerce",
            email = "<EMAIL>"
        ),
        version = "1.0"
    )
)

@SecurityScheme(
    name = "bearerAuthentication",
    description = "JWT Authorization header using the Bearer scheme",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)
@Configuration
public class SwaggerConfig {

}
