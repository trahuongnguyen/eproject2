/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Books;
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
    public static List<Books> getList(){
        List<Books> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from books";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Books book = new Books();
                book.readRecord(resultSet);
                dataList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addBook(Books book){
        connect();
        
        String sql = "insert into books(title, category_id, publisher_id, language, author_id, quantity, lost_or_broken) values(?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getCategory_id());
            statement.setInt(3, book.getPublisher_id());
            statement.setString(4, book.getLanguage());
            statement.setInt(5, book.getAuthor_id());
            statement.setInt(6, book.getQuantity());
            statement.setInt(7, book.getLost_or_broken());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editBook(Books book, int id){
        connect();
        
        String sql = "update books set title = ?, category_id = ?, publisher_id = ?, language = ?, author_id = ?, quantity = ?, lost_or_broken = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getCategory_id());
            statement.setInt(3, book.getPublisher_id());
            statement.setString(4, book.getLanguage());
            statement.setInt(5, book.getAuthor_id());
            statement.setInt(6, book.getQuantity());
            statement.setInt(7, book.getLost_or_broken());
            statement.setInt(8, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
