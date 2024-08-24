import model.Book;
import model.Member;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LibraryManager {

    private static LibraryManager libraryManager;
    private final Map<String, Book> libraryBooks;
    private final Map<String, Member> members;
    private final int MAX_BOOKS_PER_MEMBER = 5;
    private final int LOAN_DURATION_DAYS = 14;


    LibraryManager(){
        libraryBooks = new ConcurrentHashMap<>();
        members = new ConcurrentHashMap<>();
    }

    public Book getBook(String bookId){
            return libraryBooks.get(bookId);
    }
    public synchronized void borrowBooks(String memberId, String bookIsbn){
        Book book = getBook(bookIsbn);
        Member member = members.get(memberId);
        if(book != null && book.isAvailabilityStatus() && member!=null){
                Integer noOfBooksBorrowed = member.getBorrowedBooks().size();
                if(noOfBooksBorrowed + 1 > MAX_BOOKS_PER_MEMBER){
                    System.out.println("You have already borrowed maximum books , " +
                                       "Return a book to borrow one more");
                }else {
                    member.borrowBook(book);
                    book.setAvailabilityStatus(false);
                    System.out.println("Book borrowed by: " + member.getName());
                    System.out.println("Name of the book borrowed: " + bookIsbn);
                }
        }else{
            System.out.println("The requested book does not exist in the Library:  " + bookIsbn);
        }
    }
    public synchronized void returnBooks(String memberId, String bookIsbn){
        Book book = getBook(bookIsbn);
        Member member = members.get(memberId);
        if(member!=null && book!=null){
              book.setAvailabilityStatus(true);
              member.returnBook(book);
              addBook(book);
              returnBook(bookIsbn);
              System.out.println("Book returned: "+ book.getTitle() + " " + book.getAuthor());
        }else{
            System.out.println("Book or member not found");
        }
    }

    public void addBook(Book book){
        libraryBooks.put(book.getISBN(),book);
    }

    public void returnBook(String bookId){
        libraryBooks.remove(bookId);
    }

    public void registerMember(Member member){
        members.put(member.getMemberID(),member);
    }

    public void unRegisterMember(String memberId){
        members.remove(memberId);
    }

    public List<Book> searchBooks(String keyword){
        return this.libraryBooks.values().stream()
                .filter(book -> {
                    if (Objects.nonNull(keyword)) {
                        return keyword.contains(book.getTitle()) || keyword.contains(book.getAuthor());
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public static LibraryManager getLibraryManager(){
        if(libraryManager==null)return new LibraryManager();
        return libraryManager;
    }
}
