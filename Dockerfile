FROM gradle:jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build -x test --no-daemon

FROM khipu/openjdk17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]