# --------> Сборка проекта при помощи Maven

# Указываем на основе какого докер образа собираем наш образ
FROM maven:3.8.6-eclipse-temurin-17 as builder

# Установим рабочую директорию
WORKDIR /opt/app

# Копируем файл pom.xml в текущую рабочую директорию COPY [источник источник источник] [цель]
# а папки .mvn и src в директорию со своим названием
COPY pom.xml ./
COPY .mvn .mvn
COPY src src

# Запускаем сборку проекта пропуская Unit тесты
RUN mvn clean install -DskipTests


# --------> Запуск проекта после сборки
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
# Указываем докеру на каком порту приложение - докер добавит метаданные в контейнер
EXPOSE 8080
# COPY --from=<ступень> <источник> <цель>
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]




# ---- Многоступенчатая версия без установки мавена ----
# ---- Этап сборки ----
FROM eclipse-temurin:17-jdk as builder

WORKDIR /opt/app

# 1. Копируем только файлы для зависимостей
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 2. Скачиваем зависимости (кешируемый слой!)
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# 3. Копируем исходный код
COPY src src

# 4. Собираем приложение
RUN ./mvnw clean package -DskipTests

# ---- Этап запуска ----
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]