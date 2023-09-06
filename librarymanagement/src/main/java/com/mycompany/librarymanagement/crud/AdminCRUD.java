/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Tuan
 */
public class AdminCRUD extends BaseCRUD{
    public static boolean login(String username, String password){
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
        
        disconnect();
        if(admin!=null){
            return true;
        }
        return false;
    }
    
    public static void addAdmin(Admin admin){
        connect();
        
        String sql = "insert into admin(username, password, email, address) values (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getAddress());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void changePassword(Admin admin, String password){
        connect();
        
        String sql = "update Admin set password = ? where username = ?";
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
