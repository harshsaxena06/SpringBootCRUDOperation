# Product CRUD API

A RESTful CRUD API built using **Spring Boot, Spring Data JPA, and MySQL** to manage products.

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Jakarta Bean Validation

## Features

- Create a product
- Retrieve all products
- Retrieve a product by ID
- Update a product
- Delete a product
- Request validation
- Global exception handling
- Custom exception for products not found

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/products` | Create a product |
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get a product by ID |
| PUT | `/api/products/{id}` | Update a product |
| DELETE | `/api/products/{id}` | Delete a product |

## Sample Request

**POST** `/api/products`

```json
{
  "name": "Laptop",
  "quantity": 10,
  "price": 55000.00
}
```

## Database Configuration

1. Create a MySQL database named `product_db`.
2. Configure your database credentials using environment variables:
   - `DB_USERNAME`
   - `DB_PASSWORD`
3. Verify the datasource URL in `src/main/resources/application.properties`.

## Run the Application

Ensure Java 17+ and MySQL are installed and running.

```bash
mvn spring-boot:run
```

The API will be available at:

`http://localhost:8080/api/products`

Use Postman or another HTTP client to test the endpoints.
