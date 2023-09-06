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
public class Category {
    IntegerProperty id;
    StringProperty title;
    StringProperty located_in;

    public Category() {
    }

    public Category(int id, String title, String located_in) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.located_in = new SimpleStringProperty(located_in);
    }

    public IntegerProperty getProId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }
    
    public int getid(){
        return id.get();
    }

    public StringProperty getProTitle() {
        return title;
    }

    public void setTitle(StringProperty title) {
        this.title = title;
    }
    
    public String gettitle(){
        return title.get();
    }

    public StringProperty getProLocated_in() {
        return located_in;
    }

    public void setLocated_in(StringProperty located_in) {
        this.located_in = located_in;
    }
    
    public String getlocated_in(){
        return located_in.get();
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.title = new SimpleStringProperty(resultSet.getString("title"));
            this.located_in = new SimpleStringProperty(resultSet.getString("located_in"));
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
