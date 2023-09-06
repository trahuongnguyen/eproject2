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
public class Author {
    IntegerProperty id;
    StringProperty  full_name;

    public Author() {
    }

    public Author(int id, String full_name) {
        this.id = new SimpleIntegerProperty(id);
        this.full_name = new SimpleStringProperty(full_name);
    }

    public IntegerProperty getProId() {
        return id;
    }
    
    public int getid(){
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public StringProperty getProFull_name() {
        return full_name;
    }
    
    public String getfull_name(){
        return full_name.get();
    }

    public void setFull_name(String full_name) {
        this.full_name = new SimpleStringProperty(full_name);
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", full_name=" + full_name + '}';
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.full_name = new SimpleStringProperty(resultSet.getString("full_name"));
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
