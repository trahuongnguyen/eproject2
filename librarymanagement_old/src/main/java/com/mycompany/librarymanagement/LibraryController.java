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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void additem(MouseEvent event) throws IOException {      
        Pane view = getPage("additem");
        bp.setCenter(view);
    }

    @FXML
    private void addcollection(MouseEvent event) throws IOException {
        Pane view = getPage("addcollection");
        bp.setCenter(view);
    }

    @FXML
    private void dashboard(MouseEvent event) throws IOException {
        Pane view = getPage("dashboard");
        bp.setCenter(view);
    }

    @FXML
    private void library(MouseEvent event) throws IOException {
        App.setRoot("library");
    }
    
    @FXML
    private void cardmember(MouseEvent event) {
        Pane view = getPage("cardmember");
        bp.setCenter(view);
    }
    
    @FXML
    private void addauthors(MouseEvent event) throws IOException {
        Pane view = getPage("addauthors");
        bp.setCenter(view);
    }
    
    @FXML
    private void addpublisher(MouseEvent event) {
        Pane view = getPage("addpublisher");
        bp.setCenter(view);
    }
    
    @FXML
    private void librarians(MouseEvent event) {
        Pane view = getPage("librarians");
        bp.setCenter(view);
    }
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    void borrowes(MouseEvent event) {
        Pane view = getPage("borrowlist");
        bp.setCenter(view);
    }

    public Pane view;

    public Pane getPage(String fileName) {

        try {
            URL fileURL = App.class.getResource(fileName + ".fxml");
            if (fileURL == null) {
                throw new java.io.FileNotFoundException("FXML can't be found");
            }
            view = new FXMLLoader().load(fileURL);
        } catch (Exception e) {
            System.out.println("No page " + fileName + "please check FxmlLoader");
        }
        return view;
    }

    

    

    

    

}
