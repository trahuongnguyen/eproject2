/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.module.CardMembers;
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
public class CardMemberCRUD extends BaseCRUD{
    public static List<CardMembers> getList(){
        List<CardMembers> dataList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from card_members";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                CardMembers card = new CardMembers();
                card.readRecord(resultSet);
                dataList.add(card);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardMemberCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return dataList;
    }
    
    public static void addCard(CardMembers card){
        connect();
        
        String sql = "insert into card_members(full_name, phone_number, address, birthday, due_date) values (?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, card.getFull_name());
            statement.setString(2, card.getPhone_number());
            statement.setString(3, card.getAddress());
            statement.setDate(4, card.getBirthday());
            statement.setDate(5, card.getDue_date());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CardMemberCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
    
    public static void editCard(CardMembers card, int id){
        connect();
        
        String sql = "update card_members set full_name=?, phone_number=?, address=?, birthday=?, dua_date=? where id =?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, card.getFull_name());
            statement.setString(2, card.getPhone_number());
            statement.setString(3, card.getAddress());
            statement.setDate(4, card.getBirthday());
            statement.setDate(5, card.getDue_date());
            statement.setInt(11, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CardMemberCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
    }
}
