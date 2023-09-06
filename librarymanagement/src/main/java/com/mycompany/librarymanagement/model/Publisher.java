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
public class Publisher {
    IntegerProperty id;
    StringProperty name;

    public Publisher() {
    }

    public Publisher(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
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

    public StringProperty getProName() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }
    
    public String getname(){
        return name.get();
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.name = new SimpleStringProperty(resultSet.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
