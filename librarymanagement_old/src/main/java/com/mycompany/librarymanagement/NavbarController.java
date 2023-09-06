/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Pham Tuan
 */
public class NavbarController{

    @FXML
    private BorderPane bp;

    @FXML
    private Button logoutButton;

    @FXML
    void addcollection(MouseEvent event) {

    }

    @FXML
    void additem(MouseEvent event) {

    }

    @FXML
    void dashboard(MouseEvent event) {

    }

    @FXML
    void library(MouseEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }
    
    public Pane view;
    public Pane getPage(String fileName){
        
        try{
        URL fileURL = App.class.getResource(fileName+".fxml");
        if(fileURL == null){
            throw new java.io.FileNotFoundException("FXML can't be found");
        }
        view = new FXMLLoader().load(fileURL);
    }catch(Exception e){
            System.out.println("No page " + fileName+ "please check FxmlLoader");
    }
        return view;
    }
}
