# Stage 1: Build the Spring Boot application
FROM maven:3.8.4-openjdk-8-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Use a lightweight OpenJDK 8 image for the final image
FROM openjdk:8-jre-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/ecommerce.jar /app/ecommerce.jar

# Expose the port that your application listens on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "/app/ecommerce.jar"]
