# Personal Finance Management - Microservices Architecture

## System Overview

A Spring Boot-based microservices application for personal finance management, featuring:

- **API Gateway**: Central entry point with routing
- **Service Registry**: Eureka-based service discovery
- **Core Services**: User, Budget, Expense, and Notification services
- **Monitoring**: Actuator endpoints

## Services

| Service | Port | Description | API Docs |
|---------|------|-------------|----------|
| [API Gateway](./api-gateway) | 8080 | Routes requests to services | [Swagger](http://localhost:8080/swagger-ui.html) |
| [Service Registry](./service-registry) | 8761 | Service discovery dashboard | [Eureka](http://localhost:8761) |
| [User Service](./user-service) | 8081 | Manages user profiles | [Swagger](http://localhost:8081/swagger-ui.html) |
| [Budget Service](./budget-service) | 8082 | Handles budget operations | [Swagger](http://localhost:8082/swagger-ui.html) |
| [Expense Service](./expense-service) | 8083 | Tracks expenses | [Swagger](http://localhost:8083/swagger-ui.html) |
| [Notification Service](./notification-service) | 8084 | Sends alerts | [Swagger](http://localhost:8084/swagger-ui.html) |

## Prerequisites

- Java 17+
-Spring Boot Latest
- Maven 3.9+
- H2
-Spring 5


## Quick Start

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/personal-finance-manager.git
   