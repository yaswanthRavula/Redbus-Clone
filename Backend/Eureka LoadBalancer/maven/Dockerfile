FROM eclipse-temurin:17-jdk-alpine
VOLUME /temp
COPY target/*.jar maven-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080