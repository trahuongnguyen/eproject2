/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.module;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Librarians {
    String full_name;
    String address;
    String phone_number;
    Date birthday;
    String email;

    public Librarians() {
    }

    public Librarians(String full_name, String address, String phone_number, Date birthday, String email) {
        this.full_name = full_name;
        this.address = address;
        this.phone_number = phone_number;
        this.birthday = birthday;
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.full_name = resultSet.getString("full_name");
            this.address = resultSet.getString("address");
            this.phone_number = resultSet.getString("phone_number");
            this.birthday = resultSet.getDate("birthday");
            this.email = resultSet.getString("email");
        } catch (SQLException ex) {
            Logger.getLogger(Librarians.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
