FROM eclipse-temurin:17-jdk-alpine
VOLUME /temp
COPY target/*.jar app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080