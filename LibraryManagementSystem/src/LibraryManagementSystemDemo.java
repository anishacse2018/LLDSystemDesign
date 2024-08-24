import model.Book;
import model.Member;

import java.util.List;

public class LibraryManagementSystemDemo {

    public static void run(){
        LibraryManager libraryManager = LibraryManager.getLibraryManager();
        libraryManager.addBook(new Book("Book 1", "Author 1", "ISBN1", "2020"));
        libraryManager.addBook(new Book("Book 2", "Author 2", "ISBN2", "2019"));
        libraryManager.addBook(new Book("Book 3", "Author 3", "ISBN3", "2021"));

        libraryManager.registerMember(new Member("John Doe", "M1", "john@example.com"));
        libraryManager.registerMember(new Member("Jane Smith", "M2", "jane@example.com"));

        libraryManager.borrowBooks("M1","ISBN1");
        libraryManager.borrowBooks("M2","ISBN2");

        libraryManager.returnBooks("M1","ISBN1");
        libraryManager.unRegisterMember("M1");

        List<Book> searchResults = libraryManager.searchBooks("Book 2");
        System.out.println("Search Results: ");
        for(Book book : searchResults){
            System.out.println("Book Title: " + book.getTitle() + " Book Author: "+book.getAuthor());
        }
    }
}
