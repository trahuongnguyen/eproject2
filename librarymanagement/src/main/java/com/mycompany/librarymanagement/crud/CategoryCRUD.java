/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Category;
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
public class CategoryCRUD extends BaseCRUD{
    public static List<Category> getlist(){
        List<Category> categoryList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from categories";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Category cat = new Category();
                cat.readRecord(resultSet);
                categoryList.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return categoryList;
    }
    
    public static List<Category> getlistById(int id){
        List<Category> categoryList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from categories where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Category cat = new Category();
                cat.readRecord(resultSet);
                categoryList.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return categoryList;
    }
    
    public static List<Category> getlistByName(String title){
        List<Category> categoryList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from categories where title = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Category cat = new Category();
                cat.readRecord(resultSet);
                categoryList.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return categoryList;
    }
}
