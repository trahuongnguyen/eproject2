/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class Librarian {
    IntegerProperty id;
    StringProperty full_name;
    StringProperty address;
    StringProperty phone_number;
    StringProperty birthday;
    StringProperty email;

    public Librarian() {
    }

    public Librarian(int id, String full_name, String address, String phone_number, String birthday, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.full_name = new SimpleStringProperty(full_name);
        this.address = new SimpleStringProperty(address);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.birthday = new SimpleStringProperty(birthday);
        this.email = new SimpleStringProperty(email);
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

    public StringProperty getProFull_name() {
        return full_name;
    }

    public void setFull_name(StringProperty full_name) {
        this.full_name = full_name;
    }
    
    public String getfull_name(){
        return full_name.get();
    }

    public StringProperty getProAddress() {
        return address;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }
    
    public String getaddress(){
        return address.get();
    }

    public StringProperty getProPhone_number() {
        return phone_number;
    }

    public void setPhone_number(StringProperty phone_number) {
        this.phone_number = phone_number;
    }
    
    public String getphone_number(){
        return phone_number.get();
    }

    public StringProperty getproBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = new SimpleStringProperty(birthday);
    }
    
    public String getbirthday(){
        return birthday.get();
    }

    public StringProperty getProEmail() {
        return email;
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }
    
    public String getemail(){
        return email.get();
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.full_name = new SimpleStringProperty(resultSet.getString("full_name"));
            this.address = new SimpleStringProperty(resultSet.getString("address"));
            this.phone_number = new SimpleStringProperty(resultSet.getString("phone_number"));
            this.birthday = new SimpleStringProperty(resultSet.getString("birthday"));
            this.email = new SimpleStringProperty(resultSet.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
