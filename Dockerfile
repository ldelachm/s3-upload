# Use an official Amazon Corretto (AWS Java) base image
FROM amazoncorretto:11

# Set the working directory
WORKDIR /app

# Copy the Maven files first for better caching
COPY pom.xml .
COPY src ./src

# Install Maven
RUN yum install -y maven

# Build the application
RUN mvn clean package

# Run the Java application
CMD ["java", "-jar", "target/s3-upload-1.0-SNAPSHOT.jar"]
