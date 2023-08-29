/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Borrowers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BorrowerCRUD extends BaseCRUD{
    public static List<Borrowers> getList(){
        List<Borrowers> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from borrowes";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Borrowers borrowes = new Borrowers();
                borrowes.readRecord(resultSet);
                dataList.add(borrowes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addBorrow(Borrowers borrow){
        connect();
        
        String sql = "insert into borrowes(book_id, card_member_id, librarian_id, borrow_from_date, borrow_to_date, actual_returned_date, other_note, late_fee, borrow_fee, total) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, borrow.getBook_id());
            statement.setInt(2, borrow.getCard_member_id());
            statement.setInt(3, borrow.getLibrarian_id());
            statement.setDate(4, borrow.getBorrow_from_date());
            statement.setDate(5, borrow.getBorrow_to_date());
            statement.setDate(6, borrow.getActual_returned_date());
            statement.setString(7, borrow.getOther_note());
            statement.setFloat(8, borrow.getLate_fee());
            statement.setFloat(9, borrow.getBorrow_fee());
            statement.setFloat(10, borrow.getTotal());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editBorrow(Borrowers borrow, int id){
        connect();
        
        String sql = "update borrowes set book_id=?, card_member_id=?, borrow_from_date=?, borrow_to_date=?, actual_returned_date=?, other_note=?, late_fee=?, borrow_fee=?, total=? where id =?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, borrow.getBook_id());
            statement.setInt(2, borrow.getCard_member_id());
            statement.setInt(3, borrow.getLibrarian_id());
            statement.setDate(4, borrow.getBorrow_from_date());
            statement.setDate(5, borrow.getBorrow_to_date());
            statement.setDate(6, borrow.getActual_returned_date());
            statement.setString(7, borrow.getOther_note());
            statement.setFloat(8, borrow.getLate_fee());
            statement.setFloat(9, borrow.getBorrow_fee());
            statement.setFloat(10, borrow.getTotal());
            statement.setInt(11, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BorrowerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
