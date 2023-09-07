/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class Book {
    IntegerProperty id;
    StringProperty title;
    IntegerProperty category_id;
    IntegerProperty publisher_id;
    StringProperty language;
    IntegerProperty author_id;
    IntegerProperty quantity;
    IntegerProperty lost_or_broken;
    StringProperty image;

    public Book() {
    }

    public Book(int id, String title, int category_id, int publisher_id, String language, int author_id, int quantity, int lost_or_broken, String image) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.category_id = new SimpleIntegerProperty(category_id);
        this.publisher_id = new SimpleIntegerProperty(publisher_id);
        this.language = new SimpleStringProperty(language);
        this.author_id = new SimpleIntegerProperty(author_id);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.lost_or_broken = new SimpleIntegerProperty(lost_or_broken);
        this.image = new SimpleStringProperty(image);
    }

    public StringProperty getProImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = new SimpleStringProperty(image);
    }
    
    public String getimage(){
        return image.get();
    }

    public IntegerProperty getProId() {
        return id;
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
    
    public int getid(){
        return id.get();
    }

    public StringProperty getProTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }
    
    public String gettitle(){
        return title.get();
    }

    public IntegerProperty getProCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = new SimpleIntegerProperty(category_id);
    }
    
    public int getcategory_id(){
        return category_id.get();
    }

    public IntegerProperty getProPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(IntegerProperty publisher_id) {
        this.publisher_id = publisher_id;
    }
    
    public int getpublisher_id(){
        return publisher_id.get();
    }

    public StringProperty getProLanguage() {
        return language;
    }

    public void setLanguage(StringProperty language) {
        this.language = language;
    }
    
    public String getlanguage(){
        return language.get();
    }

    public IntegerProperty getProAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(IntegerProperty author_id) {
        this.author_id = author_id;
    }
    
    public int getauthor_id(){
        return author_id.get();
    }

    public IntegerProperty getProQuantity() {
        return quantity;
    }

    public void setQuantity(IntegerProperty quantity) {
        this.quantity = quantity;
    }
    
    public int getquantity(){
        return quantity.get();
    }

    public IntegerProperty getProLost_or_broken() {
        return lost_or_broken;
    }

    public void setLost_or_broken(IntegerProperty lost_or_broken) {
        this.lost_or_broken = lost_or_broken;
    }
    
    public int getlost_or_broken(){
        return lost_or_broken.get();
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.title = new SimpleStringProperty(resultSet.getString("title"));
            this.category_id = new SimpleIntegerProperty(resultSet.getInt("category_id"));
            this.publisher_id = new SimpleIntegerProperty(resultSet.getInt("publisher_id"));
            this.language = new SimpleStringProperty(resultSet.getString("language"));
            this.author_id = new SimpleIntegerProperty(resultSet.getInt("author_id"));
            this.quantity = new SimpleIntegerProperty(resultSet.getInt("quantity"));
            this.lost_or_broken = new SimpleIntegerProperty(resultSet.getInt("lost_or_broken"));
            this.image = new SimpleStringProperty(resultSet.getString("image"));
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
