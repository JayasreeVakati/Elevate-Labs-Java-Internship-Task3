import java.util.*;

class Book {
    private int bookId;
    private String bookName;
    private String author;
    private boolean isIssued = false;

    Book(int bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + bookName + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class User {
    private String name;
    private int age;
    private String dept;

    User(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age + ", Dept: " + dept;
    }
}

class Library {
    private String libraryName;
    private String address;
    private int maxBooksBorrowLimit;
    private List<Book> books;
    private List<User> users;

    Library(String libraryName, String address, int maxBooksBorrowLimit) {
        this.libraryName = libraryName;
        this.address = address;
        this.maxBooksBorrowLimit = maxBooksBorrowLimit;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Book added: " + book.getBookName());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(" User registered: " + user.getName());
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books in the library.");
            return;
        }
        System.out.println(" List of Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println(" No users registered.");
            return;
        }
        System.out.println(" Registered Users:");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println(" Book issued: " + b.getBookName());
                } else {
                    System.out.println(" Book already issued.");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println(" Book returned: " + b.getBookName());
                } else {
                    System.out.println(" Book was not issued.");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library("City Library", "Main Street", 5);

        while (true) {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Show All Books");
            System.out.println("4. Show All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, name, author));
                    break;
                case 2:
                    System.out.print("Enter User Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    library.addUser(new User(uname, age, dept));
                    break;
                case 3:
                    library.showBooks();
                    break;
                case 4:
                    library.showUsers();
                    break;
                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 7:
                    System.out.println(" Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
