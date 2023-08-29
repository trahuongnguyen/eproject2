/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Books {
    String title;
    int category_id;
    int publisher_id;
    String language;
    int author_id;
    int quantity;
    int lost_or_broken;

    public Books() {
    }

    public Books(String title, int category_id, int publisher_id, String language, int author_id, int quantity, int lost_or_broken) {
        this.title = title;
        this.category_id = category_id;
        this.publisher_id = publisher_id;
        this.language = language;
        this.author_id = author_id;
        this.quantity = quantity;
        this.lost_or_broken = lost_or_broken;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLost_or_broken() {
        return lost_or_broken;
    }

    public void setLost_or_broken(int lost_or_broken) {
        this.lost_or_broken = lost_or_broken;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.title = resultSet.getString("title");
            this.category_id = resultSet.getInt("category_id");
            this.publisher_id = resultSet.getInt("publisher_id");
            this.language = resultSet.getString("language");
            this.author_id = resultSet.getInt("author_id");
            this.quantity = resultSet.getInt("quantity");
            this.lost_or_broken = resultSet.getInt("lost_or_broken");
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
