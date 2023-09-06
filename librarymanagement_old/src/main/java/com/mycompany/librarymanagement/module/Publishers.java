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
public class Publishers {
    String name;
    String address;
    String email;
    String phone_number;

    public Publishers() {
    }

    public Publishers(String name, String address, String email, String phone_number) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.name = resultSet.getString("name");
            this.address = resultSet.getString("address");
            this.email = resultSet.getString("email");
            this.phone_number = resultSet.getString("phone_number");
        } catch (SQLException ex) {
            Logger.getLogger(Publishers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
