/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Book;
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
public class BookCRUD extends BaseCRUD{
    public static List<Book> getList(){
        List<Book> bookList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from books";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Book book = new Book();
                book.readRecord(resultSet);
                bookList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return bookList;
    }
    
    public static List<Book> getListById(int id){
        List<Book> bookList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from books where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Book book = new Book();
                book.readRecord(resultSet);
                bookList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return bookList;
    }
}
