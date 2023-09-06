/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Pham Tuan
 */
public class DashboardController implements Initializable {

    @FXML
    private BorderPane bp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void library(MouseEvent event) throws IOException {
        App.setRoot("library");
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
    
}
