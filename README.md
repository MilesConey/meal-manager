# Meal Manager
Meal Manager is a backend API I am building to practice Java, Spring Boot, PostgreSQL, and REST API development through a meal planning project.

## Features

- Meal CRUD operations
- Ingredient CRUD operations
- Meal search by name
- Meal filtering by category
- Ingredient search by name
- Request validation for required fields and non-negative numeric values
- `404 Not Found` responses for missing meal or ingredient ids

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Validation
- PostgreSQL
- Maven
- Postman

## Getting Started

### Prerequisites

- Java 17
- PostgreSQL
- Postman or another API client

### Database Setup

Create a PostgreSQL database named `meal_manager`.

Update `src/main/resources/application.properties` with your local database configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5000/meal_manager
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run the Application

From the project root:

```powershell
.\mvnw.cmd spring-boot:run
```

### Run Tests

```powershell
.\mvnw.cmd test
```

## API Reference

Base URL:

```text
http://localhost:8080
```

### Meals

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/meals` | Get all meals |
| `GET` | `/meals/{id}` | Get a meal by id |
| `GET` | `/meals?name=Chicken` | Search meals by name |
| `GET` | `/meals?category=Fish` | Filter meals by category |
| `POST` | `/meals` | Create a meal |
| `PUT` | `/meals/{id}` | Update a meal |
| `DELETE` | `/meals/{id}` | Delete a meal |

Example request body:

```json
{
  "name": "Chicken Stew",
  "description": "Warm chicken stew with vegetables",
  "category": "Chicken",
  "calories": 450
}
```

### Ingredients

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/ingredients` | Get all ingredients |
| `GET` | `/ingredients/{id}` | Get an ingredient by id |
| `GET` | `/ingredients?name=flour` | Search ingredients by name |
| `POST` | `/ingredients` | Create an ingredient |
| `PUT` | `/ingredients/{id}` | Update an ingredient |
| `DELETE` | `/ingredients/{id}` | Delete an ingredient |

Example request body:

```json
{
  "name": "Flour",
  "quantity": 2.5,
  "unit": "cups"
}
```

## Project Structure

```text
src/main/java/com/mealmanager
├── controller   REST controllers and endpoint mappings
├── entity       JPA entities mapped to database tables
├── repository   Spring Data JPA repositories
└── service      Business logic and not-found handling
```

## Validation and Error Handling

Meals:

- `name` cannot be blank
- `calories` cannot be negative

Ingredients:

- `name` cannot be blank
- `quantity` cannot be negative
- `unit` cannot be blank

Missing meal or ingredient ids return `404 Not Found`.

## Roadmap

- Connect meals and ingredients with a JPA relationship
- Add more focused controller and service tests
- Expand the API toward meal planning and grocery list features
