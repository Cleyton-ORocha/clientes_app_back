FROM eclipse-temurin:17
WORKDIR /app
COPY target/clientes_app_back-0.0.1-SNAPSHOT.jar clientes_app_back-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "clientes_app_back-0.0.1-SNAPSHOT.jar"]