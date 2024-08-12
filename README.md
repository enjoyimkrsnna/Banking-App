# Banking Application

## Overview

This is a simple banking application built with Spring Boot that allows you to manage bank accounts. You can create, retrieve, deposit, withdraw, and delete accounts. The application uses RESTful APIs to interact with account data.

## Project Structure

- `com.krishna.banking.controller`: Contains the REST controllers for handling HTTP requests.
- `com.krishna.banking.service`: Contains the service interfaces and their implementations for business logic.
- `com.krishna.banking.repository`: Contains the repository interfaces for data access.
- `com.krishna.banking.dto`: Contains data transfer objects for communication between layers.
- `com.krishna.banking.entity`: Contains entity classes representing the database structure.
- `com.krishna.banking.mapper`: Contains mapper classes to convert between entities and DTOs.

## Setup and Installation

### Prerequisites

- Java 11 or later
- Maven or Gradle
- MySQL or any other supported database

### Clone the Repository

```bash
git clone https://github.com/your-repository/banking-application.git
cd banking-application
```

### Configure Application Properties

- Create a file named `application.properties` (or `application.yml`) in `src/main/resources` directory.
- Configure the database connection properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

### Build and Run

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

#### Using Gradle

```bash
./gradlew build
./gradlew bootRun
```

## API Endpoints

### Add Account

- **Endpoint:** `POST /api/v1/accounts`
- **Request Body:**
  ```json
  {
    "accountNumber": "123456",
    "balance": 1000.0
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "accountNumber": "123456",
    "balance": 1000.0
  }
  ```

### Get Account by ID

- **Endpoint:** `GET /api/v1/accounts/{id}`
- **Response:**
  ```json
  {
    "id": 1,
    "accountNumber": "123456",
    "balance": 1000.0
  }
  ```

### Deposit Balance

- **Endpoint:** `PUT /api/v1/accounts/{id}/deposit`
- **Request Body:**
  ```json
  {
    "amount": 500.0
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "accountNumber": "123456",
    "balance": 1500.0
  }
  ```

### Withdraw Balance

- **Endpoint:** `PUT /api/v1/accounts/{id}/withdraw`
- **Request Body:**
  ```json
  {
    "amount": 200.0
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "accountNumber": "123456",
    "balance": 800.0
  }
  ```

### Get All Accounts

- **Endpoint:** `GET /api/v1/accounts`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "accountNumber": "123456",
      "balance": 800.0
    },
    {
      "id": 2,
      "accountNumber": "654321",
      "balance": 1500.0
    }
  ]
  ```

### Delete Account

- **Endpoint:** `DELETE /api/v1/accounts/{id}`
- **Response:**
  ```json
  "deleted"
  ```


