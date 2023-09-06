/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.crud;

import com.mycompany.librarymanagement.model.Author;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.BookInfo;
import com.mycompany.librarymanagement.model.Category;
import com.mycompany.librarymanagement.model.Publisher;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DELL
 */
public class BookInfoCRUD {
    public static List<BookInfo> getList(){
        List<BookInfo> dataList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        List<Publisher> publisherList = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();
        bookList = BookCRUD.getList();
        for (Book book : bookList) {
            BookInfo bookInfo = new BookInfo();
            categoryList = CategoryCRUD.getlistById(book.getcategory_id());
            StringProperty cat_name = null;
            for (Category cat : categoryList) {
                cat_name = cat.getProTitle();
            }
            publisherList = PublisherCRUD.getlistById(book.getpublisher_id());
            StringProperty publisher_name = null;
            for (Publisher publisher : publisherList) {
                publisher_name = publisher.getProName();
            }
            authorList = AuthorCRUD.getlistByID(book.getauthor_id());
            StringProperty author_name = null;
            for (Author author : authorList) {
                author_name = author.getProFull_name();
            }
            bookInfo.readRecord(book, cat_name, publisher_name, author_name);
            dataList.add(bookInfo);
        }
        
        return dataList;
    }
}
