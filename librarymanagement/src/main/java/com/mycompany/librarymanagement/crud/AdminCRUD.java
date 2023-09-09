/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Tuan
 */
public class AdminCRUD extends BaseCRUD{
    public static Admin login(String username, String password){
        Admin admin = null;
        connect();
        
        String sql = "select * from admin where username = ? and password = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                admin = new Admin();
                admin.readRecord(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql1 = "select * from admin where email = ? and password = ?";
        try {
            statement = conn.prepareStatement(sql1);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                admin = new Admin();
                admin.readRecord(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        return admin;
    }
    
    public static List<Admin> getList(){
        List<Admin> adminList = new ArrayList<>();
        connect();
        
        String sql = "select * from admin";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Admin admin = new Admin();
                admin.readRecord(resultSet);
                adminList.add(admin);
            }
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        return adminList;
    }
    
    public static void changePassword(Admin admin, String password){
        connect();
        
        String sql = "update admin set password = ? where username = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, admin.getUsername());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
