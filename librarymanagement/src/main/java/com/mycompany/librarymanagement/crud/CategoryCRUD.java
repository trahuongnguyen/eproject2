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
    
    public static void insert(Category category){
        connect();
        
        String sql = "insert into categories(title, located_in) values(?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.gettitle());
            statement.setString(2, category.getlocated_in());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void update(Category category){
        connect();
        
        String sql = "update categories set title = ?, located_in = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.gettitle());
            statement.setString(2, category.getlocated_in());
            statement.setInt(3, category.getid());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void delete(int id){
        connect();
        
        String sql = "delete from categories where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
