package com.learning.bookLibrary;
import com.learning.book.Book;
public interface IBookLibrary {
    Book borrowBook(String bookName, String userType);
    void addBook(Book book);
}
