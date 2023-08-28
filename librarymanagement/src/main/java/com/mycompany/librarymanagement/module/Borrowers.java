/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.module;

import java.sql.Date;

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
}
