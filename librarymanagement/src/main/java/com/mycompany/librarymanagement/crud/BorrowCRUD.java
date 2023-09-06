/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Borrow;
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
public class BorrowCRUD extends BaseCRUD{
    public static List<Borrow> getList(){
        List<Borrow> borrowList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from borrowes";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Borrow borrow = new Borrow();
                borrow.readRecord(resultSet);
                borrowList.add(borrow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return borrowList;
    }
    
    public static void insert(Borrow borrow){
        connect();
        
        String sql = "insert into borrowes(book_id, card_member_id, librarian_id, borrow_from_date, borrow_to_date, actual_returned_date, other_note, late_fee, borrow_fee, total) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, borrow.getbook_id());
            statement.setInt(2, borrow.getcard_member_id());
            statement.setInt(3, borrow.getlibrarian_id());
            statement.setString(4, borrow.getborrow_from_date());
            statement.setString(5,  borrow.getborrow_to_date());
            statement.setString(6, borrow.getactual_returned_date());
            statement.setString(7, borrow.getother_note());
            statement.setFloat(8, borrow.getlate_fee());
            statement.setFloat(9, borrow.getborrow_fee());
            statement.setFloat(10, borrow.gettotal());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
}
