# Use the official OpenJDK base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory into the container at /app
COPY target/service2-0.0.1-SNAPSHOT.jar /app/service2.jar

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8082

# Specify the command to run your application
CMD ["java", "-jar", "service2.jar"]
