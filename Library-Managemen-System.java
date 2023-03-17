import java.util.Date;
import java.util.List;

class Library {
    String libraryName;
    Address address;
    List<BookItem> bookItemList;
}

class Address {
    String steet;
    String pincode;
    String city;
    String state;
}

class Book {
    String bookName;
    BookType bookType;
    List<Author> authorList;
}

enum BookType {
    DRAMA, FICTION, COMEDY
}

class BookItem {
    Book book;
    String serialNo;
    Position position;
    Status bookStatus;
    User issuedTo;
}

enum Status {
    AVAILABLE, BOOKED
}

class Positon {
    Integer shelfNo;
    Integer rowNumber;
}

class Person {
    String name;
}

class Author extends Person {
    List<Book> publishedBooks;
}

class User extends Person {
    Account account;
    Search search;
    IssueBook book;
}

class Account {
    Double fine;
    String firstname;
    String lastName;
    Status status;
    String email;
}

enum Status {
    ACTIVE, BLOCKED
}

class Search {
    List<Book> findBookByName(String name);

    List<Book> findBookById(String serialNo);

    List<Book> findBookByAuthor(String authorName);
}

class IssueBook {
    BookReservationDetail getBookDetail(BookItem bookItem);

    boolean isAvailable(BookItem bookItem);

    IssueInfo issueBook(List<BookItem> bookItemList, User user);
}

class BookReservationDetail {
    Book book;
    User user;
    Date reservedUpto;
    Date bookingDate;
    Integer numberOfDays;
}

class IssueInfo {
    Date issueDate;
    User user;
    List<BookItem> bookItemList;
}

class Librarian extends User {
    void addBookItem(BookItem bookItem);

    void removeBookItem(BookItem bookItem);

    double generateFine(IssueInfo issueInfo);
}


class Library {
    String libraryName;
    Address address;
    List<BookItem> bookItemList;
}

class Address {
    String city;
    String street;
    String state;
    String pincode;
}

class Book {
    String title;
    List<Author> authorList;
    String bookId;
    BookType bookType;
}

enum BookType {
    COMEDY, ROMANTIC, HORROR
}

class BookItem {
    Position position;
    String barcode;
    Status status;
    SystemUser issuedTo;
}

enum Status {
    UNAVAILABLE, AVAILABLE;
}

class Position {
    int rackId;
    int position;
}

class Person {
    String name;
    int age;
}

class Author extends Person {
    List<Book> publishedBook;
}

class SystemUser extends Person {
    Account account;
    List<BookItem> issuedBooks;
    Search search;
    IssueBook issueBook;

    IssueDetails issueBook(BookItem bookItem);
}

class Librarian extends Person {
    Search search;
    IssueBook issueBook;
    Account account;

    IssueDetails issueBook(BookItem bookItem, SystemUser systemUser);

    void addBook(BookItem bookItem);

    void removeBook(BookItem bookItem);
}

class IssueBook {
    Fine fine;

    BookReservationDetail getReservationDetail(BookItem bookItem);

    BookReservationDetail updateReservationDetail(BookItem bookItem);

    IssueDetails issueBook(BookItem bookItem, SystemUser systemUser);

    IssueDetails renewBook(BookItem bookItem, SystemUser systemUser);
}

class Fine {
    SystemUser systemUser;
    int noOfDays;

    double calculateFine(int noOfDays);
}

class Search {
    List<BookItem> getBookByPublishionDate(Date date);

    List<BookItem> getBookByTitle(String title);

    List<BookItem> getBookByAuthor(String author);
}

class BookReservationDetail {
    SystemUser reservedBy;
    BookItem bookItem;
    Date reservedUpto;
    Status reservationStatus;
}

enum Status {
    AVAIALBLE, BOOKED;
}

class IssueDetails {
    Date issuedAt;
    SystemUser issuedTo;
    Date issuedUpto;
    BookItem bookItem;
}




-------------------------------------------------------------------------------------------------------------------------------------


class Library {
    String libraryName;
    Address address;
    List<BookItem> bookItemList;
}

class Address {
    String pinCode;
    String city;
    String state;
}

class Book {
    String uniqueId;
    String title;
    List<Author> authorList;
    BookType bookType;
}

enum BookType {
    COMEDY, FANTASY, HORROR
};

class BookItem extends Book {
    String barCode;
    Rack rack;
    Status status;
    Date issueDate;
}

class Rack {
    int number;
    String locationId;
}

class Person {
    String firstName;
    String lastName;
}

class Author extends Person {
    List<Book> publishedBooks;
}

class SystemUser extends Person {
    String email;
    Account account;
    String contactDetails;
}

class Account {
    String username;
    String password;
}

class Member extends SystemUser {
    int totalBookCheckedOut
    Search search;
    IssueBook issueBook;
}

class Librarian extends SystemUser {
    Search search;
    IssueBook issueBook;

    void addBook(BookItem bookItem);

    BookItem deleteBook(BookItem bookItem);
}

class Search {
    List<BookItem> getBookByPublicationDate(Date publicationDate);

    List<BookItem> getBookByTitle(String title);

    List<BookItem> getBookByAuthor(String authorName);
}

class IssueBook {
    Fine fine;

    BookReservationDetail getRevationDetail(BookItem bookItem);

    BookReservationDetail updateReservationDetail(BookItem bookItem, SystemUser user);

    IssueDetails issueBook(BookItem bookItem, SystemUser user);

    IssueDetails renewBook(BookItem bookItem, SystemUser user);

    Void returnBook(BookItem bookItem, SystemUser user);
}

class BookLending {
    BookItem bookItem;
    SystemUser systemUser;
}

class BookReservationDetail extends BookLending {
    Status status;
}

class IssueDetails extends BookLending {

    Date dueDate;
}

class Fine {
    Date fineDate;
    BookItem bookItem;
    SystemUser systemUser;

    Double calculateFine(int no of days);
}


