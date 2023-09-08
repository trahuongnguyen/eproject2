/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class BaseCRUD {
    static final String DB_NAME = "librarymanagement";
    static final String DB_USERNAME = "root";
    final static String DB_PW = "12345678";
    static Connection conn = null;
    static PreparedStatement statement = null;
    
    public static void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USERNAME, DB_PW);
        } catch (SQLException ex) {
            Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void disconnect(){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
