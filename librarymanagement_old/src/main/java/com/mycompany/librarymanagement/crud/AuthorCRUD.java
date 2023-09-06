/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Authors;
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
    public static void addAuthor(Authors author){
        connect();
        
        String sql = "insert into authors(full_name, birthday) values(?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, author.getFull_name());
            statement.setDate(2, author.getBirthday());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static List<Authors> getList(){
        List<Authors> dataList = new ArrayList<>();
        connect();
        
        String sql = "select * from authors";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Authors author = new Authors();
                author.readRecord(resultSet);
                dataList.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        return dataList;
    }
    
    public static void editAuthor(Authors author, int id){
        connect();
        
        String sql = "update authors set full_name = ?, birthday  = ? where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, author.getFull_name());
            statement.setDate(2, author.getBirthday());
            statement.setInt(3, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
