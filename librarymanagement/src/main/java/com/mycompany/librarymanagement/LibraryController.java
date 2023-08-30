/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LibraryController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void home(MouseEvent event) throws IOException {
        App.setRoot("dashboard");
    }

    @FXML
    private void additem(MouseEvent event) throws IOException {
        App.setRoot("additem");
    }

    @FXML
    private void addcollection(MouseEvent event) throws IOException {
        App.setRoot("addcollection");
    }

    @FXML
    private void dashboard(MouseEvent event) throws IOException {
        App.setRoot("dashboard");
    }

    @FXML
    private void library(MouseEvent event) throws IOException {
        App.setRoot("library");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    
}
