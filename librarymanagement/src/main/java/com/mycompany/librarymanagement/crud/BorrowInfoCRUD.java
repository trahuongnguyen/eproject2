/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.BorrowInfo;
import com.mycompany.librarymanagement.model.Librarian;
import com.mycompany.librarymanagement.model.Member;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class BorrowInfoCRUD extends BaseCRUD{
    public static List<BorrowInfo> getList(){
        List<BorrowInfo> dataList = new ArrayList<>();
        List<Borrow> borrowList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        List<Librarian> librarianList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();
        borrowList = BorrowCRUD.getList();
        for (Borrow borrow : borrowList) {
            BorrowInfo borrowInfo = new BorrowInfo();
            librarianList = LibrarianCRUD.getListById(borrow.getlibrarian_id());
            StringProperty librarian_name = null;
            for (Librarian librarian : librarianList) {
                librarian_name = librarian.getProEmail();
            }
            memberList = MemberCRUD.getListById(borrow.getcard_member_id());
            StringProperty member_name = null;
            for (Member member : memberList) {
                member_name = member.getProEmail();
            }
            bookList = BookCRUD.getListById(borrow.getbook_id());
            StringProperty book_name = null;
            for (Book book : bookList) {
                book_name = book.getProTitle();
            }
            borrowInfo.readRecord(borrow, book_name, librarian_name, member_name);
            dataList.add(borrowInfo);
        }
        
        return dataList;
    }
}
