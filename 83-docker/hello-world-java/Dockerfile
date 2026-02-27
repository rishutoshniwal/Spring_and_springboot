FROM eclipse-temurin:21-jdk-jammy
COPY target/*.jar app.jar
EXPOSE 5001
ENTRYPOINT ["java","-jar","/app.jar"]