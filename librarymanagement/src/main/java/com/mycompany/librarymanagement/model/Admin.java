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
import javafx.beans.property.StringProperty;

/**
 *
 * @author Pham Tuan
 */
public class Admin {
    int id;
    String username;
    String password;
    String email;
    String address;

    public Admin() {
    }

    public Admin(int id, String username, String password, String email, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", address=" + address + '}';
    }
     public void readRecord(ResultSet resultSet){
        try {
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
            this.email = resultSet.getString("email");
            this.address = resultSet.getString("address");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
