package com.example.project_java_nfk.Module;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Library {
    public ArrayList<Book> bookPrint = new ArrayList<Book>();


    @Override
    public String toString() {
        return "Library{" +
                "bookPrint=" + bookPrint +
                '}';
    }





    public void newBook(){
        Book bookOne = new Book("nightCall", "Stephen King", 2010, 1, 1, "bonjour");
        bookPrint.add(bookOne);
    }





    public ArrayList<Book> getBookPrint() {
        return bookPrint;
    }



}
