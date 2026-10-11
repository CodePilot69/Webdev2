# CRUD App Specification — Book Library Manager

## Project Description

The Book Library Manager is a single-resource web application that allows users to manage
a personal book collection. Users can add new books, view the full library, update book
details, and remove books they no longer want to track. All data is stored in memory
for this lab (no database required).

---

## Domain Entity: Book

| Field     | Type    | Description                        |
|-----------|---------|------------------------------------|
| id        | Long    | Unique identifier (auto-assigned)  |
| title     | String  | Title of the book                  |
| author    | String  | Full name of the author            |
| isbn      | String  | 13-character ISBN identifier       |
| year      | int     | Year the book was published        |

---

## Functional Requirements

REQ-1: The system shall allow a user to add a new book by providing a title, author,
       ISBN, and publication year through a web form (Create).

REQ-2: The system shall display a list of all books currently in the library, showing
       each book's title, author, ISBN, and year in a formatted table (Read).

REQ-3: The system shall allow a user to update an existing book's details by selecting
       it from the list and submitting a pre-populated edit form (Update).

REQ-4: The system shall allow a user to delete a book from the library permanently by
       clicking a delete action associated with that book (Delete).

REQ-5: The system shall validate all form inputs and redisplay the form with descriptive
       inline error messages when required fields are missing or invalid.

REQ-6: The system shall redirect the user back to the book list after a successful
       create, update, or delete operation (Post/Redirect/Get pattern).
