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
    
    public static void insert(Publisher publisher){
        connect();
        
        String sql = "insert into publishers(name) values(?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, publisher.getname());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void update(Publisher publisher){
        connect();
        
        String sql = "update publishers set name = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, publisher.getname());
            statement.setInt(2, publisher.getid());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void delete(int id){
        connect();
        
        String sql = "delete from publishers where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
