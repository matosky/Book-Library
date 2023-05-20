package com.learning;
import com.learning.book.Book;
import com.learning.bookLibrary.IBookLibrary;
import com.learning.bookLibrary.Library;
import com.learning.users.User;



/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        // Create a library instance
        Library library = new Library();

        // Add books to the library
        Book book = new Book("Book1", 1, "Author1");
        library.addBook(book);

        // Create instances of users
        User juniorStudent = new User(library, "Junior Student", "Book1");
        User teacher = new User(library, "Teacher", "Book1");
        User seniorStudent = new User(library, "Senior Student", "Book1");

        // Create threads for each user to borrow the book
        Thread juniorStudentThread = new Thread(juniorStudent);
        Thread teacherThread = new Thread(teacher);
        Thread seniorStudentThread = new Thread(seniorStudent);

        // Start the threads
        juniorStudentThread.start();
        teacherThread.start();
        seniorStudentThread.start();
    }
}
