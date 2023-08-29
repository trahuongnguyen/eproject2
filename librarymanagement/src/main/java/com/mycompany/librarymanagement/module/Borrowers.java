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
public class Borrowers {
    int book_id;
    int card_member_id;
    int librarian_id;
    Date borrow_from_date;
    Date borrow_to_date;
    Date actual_returned_date;
    String other_note;
    float late_fee;
    float borrow_fee;
    float total;

    public Borrowers() {
    }

    public Borrowers(int book_id, int card_member_id, int librarian_id, Date borrow_from_date, Date borrow_to_date, Date actual_returned_date, String other_note, float late_fee, float borrow_fee, float total) {
        this.book_id = book_id;
        this.card_member_id = card_member_id;
        this.librarian_id = librarian_id;
        this.borrow_from_date = borrow_from_date;
        this.borrow_to_date = borrow_to_date;
        this.actual_returned_date = actual_returned_date;
        this.other_note = other_note;
        this.late_fee = late_fee;
        this.borrow_fee = borrow_fee;
        this.total = total;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCard_member_id() {
        return card_member_id;
    }

    public void setCard_member_id(int card_member_id) {
        this.card_member_id = card_member_id;
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {
        this.librarian_id = librarian_id;
    }

    public Date getBorrow_from_date() {
        return borrow_from_date;
    }

    public void setBorrow_from_date(Date borrow_from_date) {
        this.borrow_from_date = borrow_from_date;
    }

    public Date getBorrow_to_date() {
        return borrow_to_date;
    }

    public void setBorrow_to_date(Date borrow_to_date) {
        this.borrow_to_date = borrow_to_date;
    }

    public Date getActual_returned_date() {
        return actual_returned_date;
    }

    public void setActual_returned_date(Date actual_returned_date) {
        this.actual_returned_date = actual_returned_date;
    }

    public String getOther_note() {
        return other_note;
    }

    public void setOther_note(String other_note) {
        this.other_note = other_note;
    }

    public float getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(float late_fee) {
        this.late_fee = late_fee;
    }

    public float getBorrow_fee() {
        return borrow_fee;
    }

    public void setBorrow_fee(float borrow_fee) {
        this.borrow_fee = borrow_fee;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.book_id = resultSet.getInt("book_id");
            this.card_member_id = resultSet.getInt("card_member_id");
            this.librarian_id = resultSet.getInt("librarian_id");
            this.borrow_from_date = resultSet.getDate("borrow_from_date");
            this.borrow_to_date = resultSet.getDate("borrow_to_date");
            this.actual_returned_date = resultSet.getDate("actual_returned_date");
            this.other_note = resultSet.getString("other_note");
            this.late_fee = resultSet.getFloat("late_fee");
            this.borrow_fee = resultSet.getFloat("borrow_fee");
            this.total = resultSet.getFloat("total");
        } catch (SQLException ex) {
            Logger.getLogger(Borrowers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
