# Stage 1: Build jar
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create final image
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/service3-0.0.1-SNAPSHOT.jar ./service3.jar
EXPOSE 8083
CMD ["java", "-jar", "service3.jar"]
