FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the JAR built by Jenkins (mvn clean package)
COPY target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

