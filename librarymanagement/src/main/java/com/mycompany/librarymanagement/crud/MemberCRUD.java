/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import static com.mycompany.librarymanagement.crud.BaseCRUD.conn;
import static com.mycompany.librarymanagement.crud.BaseCRUD.connect;
import static com.mycompany.librarymanagement.crud.BaseCRUD.disconnect;
import static com.mycompany.librarymanagement.crud.BaseCRUD.statement;
import com.mycompany.librarymanagement.model.Member;
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
public class MemberCRUD {
    public static List<Member> getList(){
        List<Member> memberList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from card_members";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Member member = new Member();
                member.readRecord(resultSet);
                memberList.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return memberList;
    }
    
    public static List<Member> getListById(int id){
        List<Member> memberList = new ArrayList<>();
        
        connect();
        
        String sql = "select * from card_member where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Member member = new Member();
                member.readRecord(resultSet);
                memberList.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
        return memberList;
    }
}