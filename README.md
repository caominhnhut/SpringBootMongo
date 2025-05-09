# Spring Boot MongoDB Example

A simple Spring Boot application demonstrating integration with MongoDB database.

## Prerequisites

- Java 17
- Maven
- Docker and Docker Compose

## Setup

1. Start MongoDB using Docker Compose:
```bash
docker compose up -d
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application with desired profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Configuration

The application uses Spring profiles for different environments:
- `dev` - Development environment
- `prod` - Production environment
- `test` - Testing environment

Each profile has its own configuration in:
- `application-dev.properties`
- `application-prod.properties`
- `application-test.properties`

Choose the appropriate profile when running the application.

Update `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://root:example@localhost:27017/spring_boot_mongo?authSource=admin
```

## API Endpoints

### Authentication Endpoints
- POST `/api/auth/login` - Authenticate user
- POST `/api/auth/signup` - Register new user
- POST `/api/auth/signout` - Logout user

### User Endpoints
- GET `/api/users` - Get all users
- GET `/api/users/{id}` - Get user by ID
- POST `/api/users` - Create new user
- PUT `/api/users/{id}` - Update user
- DELETE `/api/users/{id}` - Delete user

### Role Endpoints
- GET `/api/roles` - Get all roles (requires ADMIN or MODERATOR role)
- GET `/api/roles/{id}` - Get role by ID
- POST `/api/roles` - Create new role
- PUT `/api/roles/{id}` - Update role
- DELETE `/api/roles/{id}` - Delete role

### User-Role Endpoints
- GET `/api/user-roles` - Get all user roles
- GET `/api/user-roles/{id}` - Get user role by ID
- POST `/api/user-roles` - Create new user role
- PUT `/api/user-roles/{id}` - Update user role
- DELETE `/api/user-roles/{id}` - Delete user role

## Technologies

- Spring Boot
- Spring Data MongoDB
- Spring Security
- Spring Audit
- MongoDB
- Maven
- Lombok
