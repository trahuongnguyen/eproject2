/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class BookInfo {
    Book book;
    StringProperty category;
    StringProperty publisher;
    StringProperty author;
    
    public BookInfo() {
    }

    public BookInfo(Book book, String category, String publisher, String author) {
        this.book = book;
        this.category = new SimpleStringProperty(category);
        this.publisher = new SimpleStringProperty(publisher);
        this.author = new SimpleStringProperty(author);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
   
    public String getcategory() {
        return category.get();
    }

    public String getpublisher() {
        return publisher.get();
    }

    public String getauthor() {
        return author.get();
    }

    public StringProperty getProCategory() {
        return category;
    }

    public void setCategory(StringProperty category) {
        this.category = category;
    }

    public StringProperty getProPublisher() {
        return publisher;
    }

    public void setPublisher(StringProperty publisher) {
        this.publisher = publisher;
    }

    public StringProperty getProAuthor() {
        return author;
    }

    public void setAuthor(StringProperty author) {
        this.author = author;
    }
    
    public void readRecord(Book book, StringProperty category, StringProperty publisher, StringProperty author){
        this.book = book;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
    }
}
