package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AdminCRUD;
import com.mycompany.librarymanagement.model.Admin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChangepasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addpublisher_btn;

    @FXML
    private TextField newpass;

    @FXML
    private ImageView newpasserror;

    @FXML
    private TextField oldpass;

    @FXML
    private ImageView olpasserror;

    @FXML
    private TextField retext;

    @FXML
    private ImageView retexterror;
    
    static Admin admin;

    @FXML
    void changepassword(MouseEvent event) {
        admin = LoginController.admin;
        if(validateform()){
            AdminCRUD.changePassword(admin, newpass.getText());
            resetform();
        }
    }
    
    void resetform(){
        oldpass.setText(null);
        newpass.setText(null);
        retext.setText(null);
    }
    
    boolean validatetext(TextField txt){
        return !(txt.getText()==null||txt.getText().isEmpty());
    }
    boolean validateform (){
        boolean check = true;
        if(validatetext(newpass)){
            newpasserror.setVisible(false);
        } else {
            newpasserror.setVisible(true);
            check = false;
        }
        if(validatetext(retext)){
            retexterror.setVisible(false);
        } else{
            retexterror.setVisible(true);
            check = false;
        }
        if(validatetext(oldpass)){
            if(!oldpass.getText().equalsIgnoreCase(admin.getPassword())){
                olpasserror.setVisible(true);
                check = false;
            } else{
                olpasserror.setVisible(false);
            }
        } else{
            olpasserror.setVisible(true);
            check = false;
        }
        if(check == true){
            if(newpass.getText().equalsIgnoreCase(retext.getText())){
                check = true;
            } else{
                retexterror.setVisible(true);
                check = false;
            }
        }
        return check;
    }

    @FXML
    void initialize() {
        
    }

}
