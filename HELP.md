# WebDev2 — Week 4

Spring Boot + Thymeleaf project for the Week 4 lab.

## Running

```powershell
cd week4
mvn spring-boot:run
```

App starts on **port 8082**.

## Pages

| URL | Description |
|-----|-------------|
| http://localhost:8082/products | Product list (Task 1) |
| http://localhost:8082/products/1 | Product detail (Task 2) |
| http://localhost:8082/products/new | Create form (Task 4) |

## Task 5 — Trigger a validation error
On the Add Product form, type letters in the Price field (e.g. `abc`) and submit.
The form redisplays with an error message next to the Price field.
