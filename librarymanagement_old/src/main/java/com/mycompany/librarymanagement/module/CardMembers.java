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
public class CardMembers {
    String full_name;
    String phone_number;
    String address;
    Date birthday;
    Date due_date;

    public CardMembers() {
    }

    public CardMembers(String full_name, String phone_number, String address, Date birthday, Date due_date) {
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.due_date = due_date;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.full_name = resultSet.getString("full_name");
            this.phone_number = resultSet.getString("phone_number");
            this.address = resultSet.getString("address");
            this.birthday = resultSet.getDate("birthday");
            this.due_date = resultSet.getDate("due_date");
        } catch (SQLException ex) {
            Logger.getLogger(CardMembers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
