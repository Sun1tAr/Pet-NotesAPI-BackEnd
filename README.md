Отличный проект! Вот подготовленный `README.md` для Pet-NotesAPI-BackEnd:


# 📝 Pet Notes API BackEnd

RESTful API сервис для управления заметками. Проект создан в качестве pet-проекта для демонстрации навыков разработки на Java Spring Boot.

## 🚀 Технологии

- **Java 17**
- **Spring Boot 4.0.1**
- **Spring Data JPA** - работа с базой данных
- **Spring Web MVC** - REST API
- **Spring Validation** - валидация входных данных
- **PostgreSQL** - основная база данных
- **H2 Database** - для тестирования
- **Lombok** - уменьшение шаблонного кода
- **SpringDoc OpenAPI** - документация API (Swagger)
- **JUnit 5 / Mockito** - тестирование
- **Maven** - сборка проекта
- **Docker** - контейнеризация
- **GitHub Actions** - CI/CD

## 📋 Функциональность

- ✅ Создание заметки
- ✅ Получение заметки по ID
- ✅ Валидация входных данных
- ✅ Обработка ошибок
- ✅ Логирование запросов
- ✅ Документированное API (Swagger)

## 🏗️ Архитектура проекта

```
└── my.pet.Pet_NotesAPI_BackEnd
├── config          # Конфигурации (Swagger, Web)
├── controller      # REST контроллеры
├── dto            # Data Transfer Objects
│   ├── request     # Запросы
│   └── responce    # Ответы (NoteDTO, StatusDTO)
├── exception       # Кастомные исключения
│   └── handler     # Глобальный обработчик ошибок
├── interceptor     # Перехватчики (логирование)
├── model          # Entity модели (Note)
├── repository      # JPA репозитории
├── service        # Бизнес-логика
│   └── impl        # Реализации сервисов
└── util           # Утилиты (мапперы)
```

## 🛠️ API Endpoints

### Notes API

| Метод | Endpoint | Описание |
|-------|----------|----------|
| POST | `/notes` | Создание новой заметки |
| GET | `/notes/{id}` | Получение заметки по ID |

### Информационные endpoints

| Метод | Endpoint | Описание |
|-------|----------|----------|
| GET | `/health` | Проверка здоровья сервера |
| GET | `/ping` | Проверка корректности работы |

### 📦 Примеры запросов

#### Создание заметки
```bash
curl -X POST "http://localhost:8080/notes" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Моя заметка",
    "content": "Содержание заметки"
  }'
```

#### Получение заметки
```bash
curl -X GET "http://localhost:8080/notes/1"
```

## 📚 Документация API

После запуска приложения документация доступна по адресу:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## 🐳 Запуск с Docker

### Предварительные требования
- Docker
- Docker Compose

### Запуск

1. Клонируйте репозиторий:
```bash
git clone https://github.com/sun1tar/Pet-NotesAPI-BackEnd.git
cd Pet-NotesAPI-BackEnd
```

2. Создайте файл `.env` на основе `.docker/test.env.example`:
```bash
cp .docker/test.env.example .env
# Отредактируйте .env, установите свои пароли
```

3. Запустите приложение:
```bash
docker-compose -f .docker/docker-compose.yml up -d
```

4. Проверьте логи:
```bash
docker-compose -f .docker/docker-compose.yml logs -f app
```

Приложение будет доступно по адресу: `http://localhost:8888`

## 💻 Локальный запуск без Docker

### Предварительные требования
- Java 17
- Maven
- PostgreSQL

### Настройка

1. Создайте базу данных PostgreSQL:
```sql
CREATE DATABASE notes_db;
```

2. Настройте переменные окружения:
```bash
export POSTGRES_URL_NaPi2178e872=jdbc:postgresql://localhost:5432/notes_db
export POSTGRES_USER_NaPi2178e872=your_username
export POSTGRES_PASSWORD_NaPi2178e872=your_password
```

3. Соберите проект:
```bash
mvn clean package
```

4. Запустите приложение:
```bash
java -jar target/Pet-NotesAPI-BackEnd-1.0.0.jar
```

## 🧪 Тестирование

Запуск всех тестов:
```bash
mvn test
```

## 🔄 CI/CD

Проект использует GitHub Actions для автоматической сборки и деплоя:

- **build-deploy-config.yml** - сборка Docker образа и деплой на VPS
- **release.yml** - создание релиза при пуше тегов v*

## 📄 Конфигурация

Основные настройки в `application.properties`:

```properties
# База данных
spring.datasource.url=${POSTGRES_URL_NaPi2178e872}
spring.datasource.username=${POSTGRES_USER_NaPi2178e872}
spring.datasource.password=${POSTGRES_PASSWORD_NaPi2178e872}

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# Swagger
springdoc.swagger-ui.path=/swagger-ui.html
```

## 🌐 Продакшен

Приложение развернуто и доступно по адресу:
```
http://denchik2376.fvds.ru/Pet-NotesAPI-BackEnd/swagger-ui/index.html
```

## 🤝 Вклад в проект

1. Форкните репозиторий
2. Создайте ветку для фичи (`git checkout -b feature/amazing-feature`)
3. Зафиксируйте изменения (`git commit -m 'Add amazing feature'`)
4. Отправьте изменения (`git push origin feature/amazing-feature`)
5. Откройте Pull Request

## 📝 Лицензия

MIT License

## ✨ Автор

**sun1tar**

## 📞 Контакты

- GitHub: [@sun1tar](https://github.com/sun1tar)
- Проект: [Pet-NotesAPI-BackEnd](https://github.com/sun1tar/Pet-NotesAPI-BackEnd)

---


