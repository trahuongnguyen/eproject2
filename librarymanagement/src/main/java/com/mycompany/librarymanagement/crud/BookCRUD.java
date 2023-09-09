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
    
    public static List<Book> getListByName(String title){
        List<Book> bookList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from books where title = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, title);
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
    
    public static List<Book> getListByAuthorId(int id){
        List<Book> bookList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from books where author_id = ?";
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
    
    public static void deleteBook(int id){
        connect();
        
        String sql = "delete from books where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void update(Book book, int id){
        connect();
        
        String sql = "update books set title=?, category_id = ?, publisher_id = ?, language = ?, author_id = ?, quantity = ?, lost_or_broken = ?, image = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, book.gettitle());
            statement.setInt(2, book.getcategory_id());
            statement.setInt(3, book.getpublisher_id());
            statement.setString(4, book.getlanguage());
            statement.setInt(5, book.getauthor_id());
            statement.setInt(6, book.getquantity());
            statement.setInt(7, book.getlost_or_broken());
            statement.setString(8, book.getimage());
            statement.setInt(9, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void insert(Book book){
        connect();
        
        String sql = "insert into books(title, category_id, publisher_id, language, author_id, quantity, lost_or_broken, image) values(?,?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, book.gettitle());
            statement.setInt(2, book.getcategory_id());
            statement.setInt(3, book.getpublisher_id());
            statement.setString(4, book.getlanguage());
            statement.setInt(5, book.getauthor_id());
            statement.setInt(6, book.getquantity());
            statement.setInt(7, book.getlost_or_broken());
            statement.setString(8, book.getimage());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
