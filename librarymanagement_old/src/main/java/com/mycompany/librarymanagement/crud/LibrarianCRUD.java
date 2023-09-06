/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.Librarians;
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
public class LibrarianCRUD extends BaseCRUD{
    public static List<Librarians> getList(){
        List<Librarians> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from librarians";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Librarians libra = new Librarians();
                libra.readRecord(resultSet);
                dataList.add(libra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addLibrarian(Librarians libra){
        connect();
        
        String sql = "insert into librarians(full_name, address, phone_number, birthday, email) values (?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, libra.getFull_name());
            statement.setString(2, libra.getAddress());
            statement.setString(3, libra.getPhone_number());
            statement.setDate(4, libra.getBirthday());
            statement.setString(5, libra.getEmail());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editLibrarian(Librarians libra, int id){
        connect();
        
        String sql = "update Librarians set full_name=?, address = ?, phone_number=?, birthday = ?, email = ? where id =?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, libra.getFull_name());
            statement.setString(2, libra.getAddress());
            statement.setString(3, libra.getPhone_number());
            statement.setDate(4, libra.getBirthday());
            statement.setString(5, libra.getEmail());
            statement.setInt(11, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
