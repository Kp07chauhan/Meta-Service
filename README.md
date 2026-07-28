# Enterprise Backend Platform

A production-ready Java Spring Boot Microservices project built using Spring Cloud. The project demonstrates authentication, service discovery, API gateway routing, Docker containerization, and MySQL integration.

## Architecture

- API Gateway
- Eureka Server (Service Discovery)
- Auth Service (JWT Authentication & Authorization)
- CRUD Service
- MySQL Database
- Docker & Docker Compose

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- Spring Data JPA
- Hibernate
- MySQL
- JWT
- Maven
- Docker
- Docker Compose

## Project Structure

```
Enterprise-Backend-Platform
│
├── API GATEWAY
├── AUTH SERVICE
├── CRUD SERVICE
├── EUREKA SERVER
├── mysql-init
├── docker-compose.yml
└── README.md
```

## Features

- JWT Authentication & Authorization
- Service Discovery using Eureka Server
- API Gateway Routing
- RESTful APIs
- MySQL Database Integration
- Dockerized Microservices
- Spring Data JPA
- Secure Password Encryption
- Layered Architecture

## Prerequisites

- Java 21
- Maven
- Docker Desktop
- Git

## Clone Repository

```bash
git clone https://github.com/<your-username>/Enterprise-Backend-Platform.git

cd Enterprise-Backend-Platform
```

## Build Services

Run the following command inside each service folder:

```bash
./mvnw clean package -DskipTests
```

Windows:

```bash
mvnw.cmd clean package -DskipTests
```

## Run Using Docker

```bash
docker compose up --build
```

## Services

| Service | Port |
|---------|------|
| API Gateway | 8080 |
| Auth Service | 8081 |
| CRUD Service | 8082 |
| Eureka Server | 8761 |
| MySQL | 3306 (Container) |

## Environment Variables

The project uses environment variables for sensitive information.

Example:

```
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_secret_key
MAIL_USERNAME=your_email
MAIL_PASSWORD=your_app_password
```

## API Endpoints

### Authentication

```
POST /auth/register
POST /auth/login
```

### CRUD

```
GET /users
POST /users
PUT /users/{id}
DELETE /users/{id}
```

*(Update these endpoints according to your project.)*

## Future Improvements

- Config Server
- Circuit Breaker (Resilience4j)
- Distributed Tracing
- Centralized Logging
- Kafka Integration
- CI/CD Pipeline
- Kubernetes Deployment

## Author

**Kapil Kumar Chauhan**

Java Backend Developer

GitHub: https://github.com/Kp07chauhan

LinkedIn: www.linkedin.com/in/kp07kr-chauhan

## License

This project is created for learning and portfolio purposes.