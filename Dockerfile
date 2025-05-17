# Use official Maven image with JDK
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project (optional step)
RUN mvn clean install

# Run tests
CMD ["mvn", "test"]