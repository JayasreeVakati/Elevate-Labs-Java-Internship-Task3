# Elevate-Labs-Java-Internship-Task3
Objective:

Build a Library Management System in Java using Object-Oriented Programming (OOP) principles, allowing users to:

Add books

Register users

Issue and return books

View book/user lists

🔧 1. Object-Oriented Design

We created three main classes:

👉 Book, User, Library
🔹 Class: Book

Purpose: Represents a single book in the library.

Properties (Fields):

bookId: Unique ID for the book

bookName: Title of the book

author: Author of the book

isIssued: Boolean flag to check if the book is issued or not

Key Methods:

issue() – Marks the book as issued

returnBook() – Marks the book as available

toString() – Returns book details for printing

🔹 Class: User

Purpose: Represents a person (student/staff) who can borrow books.

Properties:

name

age

dept (department)

Key Methods:

Getters

toString() for displaying user details

🔹 Class: Library

Purpose: Acts as the central controller for managing books and users.

Properties:

libraryName, address

maxBooksBorrowLimit: Optional future use

List<Book> – A collection of all books

List<User> – A collection of registered users

Key Methods:

addBook(Book b) – Adds a book to the collection

addUser(User u) – Adds a user to the system

showBooks() – Displays all books

showUsers() – Displays all registered users

issueBook(int id) – Issues a book by ID

returnBook(int id) – Returns a book by ID

🧑‍💻 2. Class: Main (Driver Class)

This contains the main() method and acts as the UI/Controller for the system.

Features:

Uses a Scanner for input

Shows a menu to the user:

1. Add Book
2. Register User
3. Show All Books
4. Show All Users
5. Issue Book
6. Return Book
7. Exit


Based on the user's choice, it calls appropriate methods from the Library class

✅ 3. Functional Flow Summary
Step	What Happens
Add Book	User enters book info → stored in books list
Register User	User enters name, age, dept → stored in users list
Show Books	Loops through books list and prints each book
Show Users	Loops through users list and prints each user
Issue Book	Searches for book by ID → if not issued, marks it as issued
Return Book	Searches for book by ID → if issued, marks it as returned
