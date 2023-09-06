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
public class Member {
    IntegerProperty id;
    StringProperty full_name;
    StringProperty address;
    StringProperty phone_number;
    Date birthday;
    StringProperty email;
    Date due_date;

    public Member() {
    }

    public Member(int id, String full_name, String address, String phone_number, Date birthday, String email, Date due_date) {
        this.id = new SimpleIntegerProperty(id);
        this.full_name = new SimpleStringProperty(full_name);
        this.address = new SimpleStringProperty(address);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.birthday = birthday;
        this.email = new SimpleStringProperty(email);
        this.due_date = due_date;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.full_name = new SimpleStringProperty(resultSet.getString("full_name"));
            this.address = new SimpleStringProperty(resultSet.getString("address"));
            this.phone_number = new SimpleStringProperty(resultSet.getString("phone_number"));
            this.birthday = resultSet.getDate("birthday");
            this.email = new SimpleStringProperty(resultSet.getString("email"));
            this.due_date = resultSet.getDate("due_date");
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
