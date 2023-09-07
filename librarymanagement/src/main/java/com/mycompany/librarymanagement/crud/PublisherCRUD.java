/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Publisher;
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
public class PublisherCRUD extends BaseCRUD{
    public static List<Publisher> getlist(){
        List<Publisher> publisherList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from publishers";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Publisher pub = new Publisher();
                pub.readRecord(resultSet);
                publisherList.add(pub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return publisherList;
    }
    
    public static List<Publisher> getlistById(int id){
        List<Publisher> publisherList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from publishers where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Publisher pub = new Publisher();
                pub.readRecord(resultSet);
                publisherList.add(pub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return publisherList;
    }
    
    public static List<Publisher> getlistByName(String name){
        List<Publisher> publisherList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from publishers where name = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Publisher pub = new Publisher();
                pub.readRecord(resultSet);
                publisherList.add(pub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return publisherList;
    }
}
