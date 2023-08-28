/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.librarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LoginController{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private FontAwesomeIconView libraryicon;

    @FXML
    private Button loginbutton;

    @FXML
    private FontAwesomeIconView nameicon;

    @FXML
    private FontAwesomeIconView passwordicon;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private FontAwesomeIconView usericon;

    @FXML
    private TextField usernametxt;

    @FXML
    void initialize() {
    }

    @FXML
    void login(ActionEvent event) {

    }
}
