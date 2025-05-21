# 🛒 Ecommerce - Spring Boot

Este es un proyecto de ejemplo de una aplicación de ecommerce desarrollada con **Spring Boot**, como parte de un curso práctico. El proyecto incluye funcionalidades básicas para la gestión de usuarios, productos, autenticación, seguridad y configuración de entorno de producción con Docker.

---

## 🚀 Características Principales

- Gestión de productos y usuarios
- Autenticación y autorización (Spring Security)
- Arquitectura por capas (Controller, Service, Repository)
- Manejo de excepciones personalizado
- Mapeo de entidades con DTOs
- Configuración para despliegue en producción
- Contenerización con Docker

---

## 🧰 Tecnologías Usadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- Docker
- Gradle

---

## 📁 Estructura del Proyecto

```bash
src/
├── config           # Configuraciones globales
├── controller       # Controladores REST
├── dto              # Objetos de transferencia de datos
├── entity           # Entidades JPA
├── exception        # Manejo de errores personalizado
├── mapper           # Mapeo entre entidades y DTOs
├── repository       # Interfaces de acceso a datos
├── security         # Configuración de seguridad
├── service          # Lógica de negocio
├── util             # Clases utilitarias
