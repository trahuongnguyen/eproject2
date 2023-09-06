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
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class Borrow {
    IntegerProperty id;
    IntegerProperty book_id;
    IntegerProperty card_member_id;
    IntegerProperty librarian_id;
    StringProperty borrow_from_date;
    StringProperty borrow_to_date;
    StringProperty actual_returned_date;
    StringProperty other_note;
    FloatProperty late_fee;
    FloatProperty borrow_fee;
    FloatProperty total;

    public Borrow() {
    }

    public Borrow(int id, int book_id, int card_member_id, int librarian_id, String borrow_from_date, String borrow_to_date, String actual_returned_date, String other_note, float late_fee, float borrow_fee, float total) {
        this.id = new SimpleIntegerProperty(id);
        this.book_id = new SimpleIntegerProperty(book_id);
        this.card_member_id = new SimpleIntegerProperty(card_member_id);
        this.librarian_id = new SimpleIntegerProperty(librarian_id);
        this.borrow_from_date = new SimpleStringProperty(borrow_from_date);
        this.borrow_to_date = new SimpleStringProperty(borrow_to_date);
        this.actual_returned_date = new SimpleStringProperty(actual_returned_date);
        this.other_note = new SimpleStringProperty(other_note);
        this.late_fee = new SimpleFloatProperty(late_fee);
        this.borrow_fee = new SimpleFloatProperty(borrow_fee);
        this.total = new SimpleFloatProperty(late_fee + borrow_fee);
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

    public IntegerProperty getProBook_id() {
        return book_id;
    }

    public void setBook_id(IntegerProperty book_id) {
        this.book_id = book_id;
    }
    
    public int getbook_id(){
        return book_id.get();
    }

    public IntegerProperty getProCard_member_id() {
        return card_member_id;
    }

    public void setCard_member_id(IntegerProperty card_member_id) {
        this.card_member_id = card_member_id;
    }
    
    public int getcard_member_id(){
        return card_member_id.get();
    }

    public IntegerProperty getProLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(IntegerProperty librarian_id) {
        this.librarian_id = librarian_id;
    }
    
    public int getlibrarian_id(){
        return librarian_id.get();
    }

    public StringProperty getProBorrow_from_date() {
        return borrow_from_date;
    }

    public void setBorrow_from_date(String borrow_from_date) {
        this.borrow_from_date = new SimpleStringProperty(borrow_from_date);
    }
    
    public String getborrow_from_date(){
        return borrow_from_date.get();
    }

    public StringProperty getProBorrow_to_date() {
        return borrow_to_date;
    }

    public void setBorrow_to_date(String borrow_to_date) {
        this.borrow_to_date = new SimpleStringProperty(borrow_to_date);
    }
    
    public String getborrow_to_date(){
        return borrow_to_date.get();
    }

    public StringProperty getProActual_returned_date() {
        return actual_returned_date;
    }

    public void setActual_returned_date(String actual_returned_date) {
        this.actual_returned_date = new SimpleStringProperty(actual_returned_date);
    }
    
    public String getactual_returned_date(){
        return actual_returned_date.get();
    }

    public StringProperty getProOther_note() {
        return other_note;
    }

    public void setOther_note(StringProperty other_note) {
        this.other_note = other_note;
    }
    
    public String getother_note(){
        return other_note.get();
    }

    public FloatProperty getProLate_fee() {
        return late_fee;
    }

    public void setLate_fee(FloatProperty late_fee) {
        this.late_fee = late_fee;
    }
    
    public float getlate_fee(){
        return late_fee.get();
    }

    public FloatProperty getproBorrow_fee() {
        return borrow_fee;
    }

    public void setBorrow_fee(FloatProperty borrow_fee) {
        this.borrow_fee = borrow_fee;
    }
    
    public float getborrow_fee(){
        return borrow_fee.get();
    }

    public FloatProperty getProTotal() {
        return total;
    }

    public void setTotal(FloatProperty total) {
        this.total = total;
    }
    
    public float gettotal(){
        return total.get();
    }
    
    public void readRecord(ResultSet resultSet){
        try {
            this.id = new SimpleIntegerProperty(resultSet.getInt("id"));
            this.book_id = new SimpleIntegerProperty(resultSet.getInt("book_id"));
            this.card_member_id = new SimpleIntegerProperty(resultSet.getInt("card_member_id"));
            this.librarian_id = new SimpleIntegerProperty(resultSet.getInt("librarian_id"));
            this.borrow_from_date = new SimpleStringProperty(resultSet.getString("borrow_from_date"));
            this.borrow_to_date = new SimpleStringProperty(resultSet.getString("borrow_to_date"));
            this.actual_returned_date = new SimpleStringProperty(resultSet.getString("actual_returned_date"));
            this.other_note = new SimpleStringProperty(resultSet.getString("other_note"));
            this.late_fee = new SimpleFloatProperty(resultSet.getFloat("late_fee"));
            this.borrow_fee = new SimpleFloatProperty(resultSet.getFloat("borrow_fee"));
            this.total = new SimpleFloatProperty(resultSet.getFloat("total"));
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
