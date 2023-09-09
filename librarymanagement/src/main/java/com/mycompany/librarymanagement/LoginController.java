/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AdminCRUD;
import com.mycompany.librarymanagement.model.Admin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pham Tuan
 */
public class LoginController implements Initializable {

    @FXML
    private Button lognButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;
    
    @FXML
    private Label usernameMessageLable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    static Admin admin;
    @FXML
    private void login(ActionEvent event) throws IOException {
        
        if (usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            admin = AdminCRUD.login(usernameTextField.getText(), passwordField.getText());
            if (admin!=null) {
                App.setRoot("homepage");
            }else{
                usernameMessageLable.setText("Tài khoản không chính xác.");
            }
        }else{
            usernameMessageLable.setText("Vui lòng nhập đủ thông tin.");
        }
        
    }
    
    
}
