FROM eclipse-temurin:17-jdk-alpine
VOLUME /temp
COPY target/*.jar loadbalancer-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/loadbalancer-0.0.1-SNAPSHOT.war"]
EXPOSE 8080