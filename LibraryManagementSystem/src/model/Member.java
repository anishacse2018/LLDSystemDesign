package model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private  String memberID;
    private String contactInfo;
    private List<Book> borrowedBooks;

    public Member(String name, String memberID, String contactInfo) {
        this.name = name;
        this.memberID = memberID;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book){
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        this.borrowedBooks.remove(book);
    }
}
