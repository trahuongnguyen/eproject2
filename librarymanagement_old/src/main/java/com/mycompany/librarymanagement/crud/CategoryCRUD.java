/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Categories;
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
    public static List<Categories> getList(){
        List<Categories> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from categories";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Categories category = new Categories();
                category.readRecord(resultSet);
                dataList.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addCategory(Categories category){
        connect();
        
        String sql = "insert into categories(title, located_in) values (?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.getTitle());
            statement.setString(2, category.getLocated_in());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editCategory(Categories category, int id){
        connect();
        
        String sql = "update categories set title=?, located_in=? where id =?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.getTitle());
            statement.setString(2, category.getLocated_in());
            statement.setInt(11, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
