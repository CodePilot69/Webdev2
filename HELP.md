# WebDev2 — Week 3

Spring Boot project for the WebDev2 Week 3 lab — HTTP Request Mapping.

## Running the application

```powershell
cd week3
mvn spring-boot:run
```

The application starts on **port 8082**.

## Endpoints

| Method | URL                        | Description                          |
|--------|----------------------------|--------------------------------------|
| GET    | /books                     | List all books                       |
| GET    | /books?author=Robert       | Filter books by author               |
| GET    | /books/{id}                | Get one book (200 OK or 404)         |
| POST   | /books?title=X&author=Y&price=Z | Add a book, redirects to GET /books |

## Evidence URLs (once running)

- All books:       http://localhost:8082/books
- Filter by author: http://localhost:8082/books?author=Robert
- Single book (200): http://localhost:8082/books/1
- Missing book (404): http://localhost:8082/books/99
