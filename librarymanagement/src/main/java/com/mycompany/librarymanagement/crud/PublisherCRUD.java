/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Publishers;
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
    public static List<Publishers> getList(){
        List<Publishers> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from publishers";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Publishers pub = new Publishers();
                pub.readRecord(resultSet);
                dataList.add(pub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addPublisher(Publishers pub){
        connect();
        
        String sql = "insert into publishers(name, address, email, phone_number) values (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, pub.getName());
            statement.setString(2, pub.getAddress());
            statement.setString(3, pub.getEmail());
            statement.setString(4, pub.getPhone_number());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editLibrarian(Publishers pub, int id){
        connect();
        
        String sql = "update publishers set name=?, address = ?, email=?, phone_number = ? where id =?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, pub.getName());
            statement.setString(2, pub.getAddress());
            statement.setString(3, pub.getEmail());
            statement.setString(4, pub.getPhone_number());
            statement.setInt(11, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
