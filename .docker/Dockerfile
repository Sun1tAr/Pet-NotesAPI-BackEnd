# Сборка проекта при помощи Maven
FROM maven:3.8.6-eclipse-temurin-17 as builder
WORKDIR /opt/app
COPY pom.xml ./
COPY .mvn .mvn
COPY src src
RUN mvn clean package -DskipTests


#  Запуск проекта после сборки
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]




