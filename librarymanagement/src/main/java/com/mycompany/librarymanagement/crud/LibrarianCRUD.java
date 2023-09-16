/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Librarian;
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
public class LibrarianCRUD extends BaseCRUD{
    public static List<Librarian> getList(){
        List<Librarian> librarianList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from librarians";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Librarian librarian = new Librarian();
                librarian.readRecord(resultSet);
                librarianList.add(librarian);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return librarianList;
    }
    
    public static List<Librarian> getListById(int id){
        List<Librarian> librarianList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from librarians where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Librarian librarian = new Librarian();
                librarian.readRecord(resultSet);
                librarianList.add(librarian);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return librarianList;
    }
    
    public static List<Librarian> getListByEmail(String email){
        List<Librarian> librarianList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from librarians where email = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Librarian librarian = new Librarian();
                librarian.readRecord(resultSet);
                librarianList.add(librarian);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return librarianList;
    }
    
    public static List<Librarian> getListByName(String email){
        List<Librarian> librarianList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from librarians where email = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Librarian librarian = new Librarian();
                librarian.readRecord(resultSet);
                librarianList.add(librarian);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return librarianList;
    }
    
    public static void insert(Librarian librarian){
        connect();
        
        String sql = "insert into librarians(full_name, address, birthday, email, phone_number) values (?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, librarian.getfull_name());
            statement.setString(2, librarian.getaddress());
            statement.setString(3, librarian.getbirthday());
            statement.setString(4, librarian.getemail());
            statement.setString(5, librarian.getphone_number());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void update(Librarian librarian){
        connect();
        
        String sql = "update librarians set full_name = ?, address = ?, birthday = ?, email = ?, phone_number = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, librarian.getfull_name());
            statement.setString(2, librarian.getaddress());
            statement.setString(3, librarian.getbirthday());
            statement.setString(4, librarian.getemail());
            statement.setString(5, librarian.getphone_number());
            statement.setInt(6, librarian.getid());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void delete(int id){
        connect();
        
        String sql = "delete from librarians where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
