/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class BorrowInfo {
    Borrow borrow;
    StringProperty book;
    StringProperty librarian;
    StringProperty member;

    public BorrowInfo() {
    }

    public BorrowInfo(Borrow borrow, String book, String librarian, String member) {
        this.borrow = borrow;
        this.book = new SimpleStringProperty(book);
        this.librarian = new SimpleStringProperty(librarian);
        this.member = new SimpleStringProperty(member);
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
    

    public String getbook() {
        return book.get();
    }

    public String getlibrarian() {
        return librarian.get();
    }

    public String getmember() {
        return member.get();
    }

    public StringProperty getProBook() {
        return book;
    }

    public void setBook(StringProperty book) {
        this.book = book;
    }

    public StringProperty getProLibrarian() {
        return librarian;
    }

    public void setLibrarian(StringProperty librarian) {
        this.librarian = librarian;
    }

    public StringProperty getProMember() {
        return member;
    }

    public void setMember(StringProperty member) {
        this.member = member;
    }
    
    public void readRecord(Borrow borrow, StringProperty book, StringProperty librarian, StringProperty member){
        this.borrow = borrow;
        this.book = book;
        this.librarian = librarian;
        this.member = member;
    }
}
