/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement.module;

/**
 *
 * @author DELL
 */
public class Categories {
    String title;
    String located_in;

    public Categories() {
    }

    public Categories(String title, String located_in) {
        this.title = title;
        this.located_in = located_in;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocated_in() {
        return located_in;
    }

    public void setLocated_in(String located_in) {
        this.located_in = located_in;
    }
    
}
