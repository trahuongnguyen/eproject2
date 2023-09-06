/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Author;
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
public class AuthorCRUD extends BaseCRUD{
    public static List<Author> getlist(){
        List<Author> authorList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from authors";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Author au = new Author();
                au.readRecord(resultSet);
                authorList.add(au);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return authorList;
    }
    
    public static List<Author> getlistByID(int id){
        List<Author> authorList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from authors where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Author au = new Author();
                au.readRecord(resultSet);
                authorList.add(au);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return authorList;
    }
    
    public static void insert(Author author){
        connect();
        
        String sql = "insert into authors(full_name) values (?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, author.getfull_name());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
