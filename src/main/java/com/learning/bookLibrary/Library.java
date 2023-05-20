package com.learning.bookLibrary;

import com.learning.book.Book;

import java.util.*;

public class Library implements IBookLibrary {
    private List<Book> books;
    private Map<String, Integer> bookRequests;

    public Library() {
        books = new ArrayList<>();
        bookRequests = new HashMap<>();
    }

    public void addBook(Book book) {
        int id = books.size();
        Book newBook = book;
        newBook.setId(id);
        books.add(newBook);
    }

    public synchronized Book borrowBook(String bookName, String userType) {
        for (Book b : books) {
            if (b.getTitle().equals(bookName)) {
                String requestKey = bookName;
                Integer existingPriority = bookRequests.getOrDefault(requestKey, 0);
                int newPriority = getPriority(userType);

                if (newPriority > existingPriority) {
                    bookRequests.put(requestKey, newPriority);
                    books.remove(b);
                    return b;
                }
            }
        }
        return null;
    }

    private int getPriority(String userType) {
        if (userType.equals("Teacher")) {
            return 2;
        } else if (userType.equals("Senior Student")) {
            return 1;
        } else {
            return 0; // Junior Student and other user types
        }
    }
}
