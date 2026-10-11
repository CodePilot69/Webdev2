# WebDev2 — Week 5: Book Library CRUD App

## Running

```powershell
cd week5
mvn spring-boot:run
```

App starts on **port 8082**.

## Pages

| URL | Description |
|-----|-------------|
| http://localhost:8082/books | List all books (Read) |
| http://localhost:8082/books/new | Add a book (Create) |
| http://localhost:8082/books/1/edit | Edit book #1 (Update) |
| Delete button on list page | Remove a book (Delete) |

## Trigger validation errors (Task 5 evidence)
- Leave Title blank → "Title is required"
- Enter `abc` as ISBN → "ISBN must be exactly 13 digits"
- Enter `500` as Year → passes; enter `abc` → "Publication year is required"
