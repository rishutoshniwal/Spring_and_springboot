FROM maven:3.9.11-amazoncorretto-25-alpine AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:21-jdk-jammy
EXPOSE 5001
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]