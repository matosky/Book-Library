package com.learning.users;
import com.learning.book.Book;
import com.learning.bookLibrary.Library;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class User implements Runnable {
    private static final Logger logger = LogManager.getLogger(User.class);

    private Library library;
    private String userType;
    private String bookToBorrowTitle;

    public User(Library library, String userType, String bookToBorrowTitle) {
        this.library = library;
        this.userType = userType;
        this.bookToBorrowTitle = bookToBorrowTitle;
    }

    public void run() {
        synchronized (library) {
            try{
                Book book = library.borrowBook(bookToBorrowTitle, this.userType);
                if(book==null){
                    throw new NullPointerException("Book taken");
                }
                logger.info(this.userType + " borrowed" + book.getTitle());
            }catch (NullPointerException e){
                String errMsg = e.getMessage();
                logger.info(errMsg);
            }
        }
    }
}
