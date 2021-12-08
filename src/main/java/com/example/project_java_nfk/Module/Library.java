package com.example.project_java_nfk.Module;

import java.util.ArrayList;

public class Library {
    @Override
    public String toString() {
        return "Library{" +
                "bookPrint=" + bookPrint +
                '}';
    }

    public ArrayList<Book> bookPrint = new ArrayList<Book>();



    public void newBook(){
        Book bookOne = new Book("nightCall", "Stephen King", 2010, 1, 1, "bonjour");
        bookPrint.add(bookOne);
    }


}
