package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.LibrarianCRUD;
import com.mycompany.librarymanagement.model.Librarian;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddlibrarianController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addlibrarian_btn;

    @FXML
    private ImageView erroraddress;

    @FXML
    private ImageView errorbirthday;

    @FXML
    private ImageView erroremail;

    @FXML
    private ImageView errorfullname;

    @FXML
    private ImageView errorphone;

    @FXML
    private TextField txtaddress;

    @FXML
    private DatePicker txtbirthday;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtfullname;

    @FXML
    private TextField txtphone;

    @FXML
    void addlibrarian(MouseEvent event) {
        librarian = new Librarian(
                0, 
                !txtfullname.getText().isEmpty()&& !txtfullname.getText().isBlank()?txtfullname.getText():"",
                !txtaddress.getText().isEmpty()&&!txtaddress.getText().isBlank()?txtaddress.getText():"", 
                validatephone(txtphone)?txtphone.getText():"", 
                txtbirthday.getValue()!=null?txtbirthday.getValue().getYear() + "-" + txtbirthday.getValue().getMonthValue() + "-" + txtbirthday.getValue().getDayOfMonth():"", 
                validateemail(txtemail)?txtemail.getText():"");
        if(validateform(librarian)){
            List<Librarian> librarianList = LibrarianCRUD.getListByEmail(librarian.getemail());
            boolean isHave = false;
            if(librarianList.size()<=0){
                LibrarianCRUD.insert(librarian);
                resertform();
            } else{
                for (Librarian librarian1 : librarianList) {
                    if(librarian1.getfull_name().equalsIgnoreCase(librarian.getfull_name())){
                        if(librarian1.getbirthday().equalsIgnoreCase(librarian.getbirthday())){
                            resertform();
                            isHave = true;
                            break;
                        }
                    }
                }
                if(!isHave){
                    LibrarianCRUD.insert(librarian);
                    resertform();
                }
            }
        }
    }
    
    static Librarian librarian;

    boolean validatephone(TextField phone) {
        int n;
        try {
            n = Integer.parseInt(phone.getText());
        } catch (NumberFormatException e) {
            errorphone.setVisible(true);
            return false;
        }
        String regex = "[0]{1}[1-9]{1}[0-9]{8,9}";
        boolean check = Pattern.compile(regex).matcher(!phone.getText().isEmpty()&&!phone.getText().isBlank()?phone.getText():"").matches();
        if(check==false){
            errorphone.setVisible(true);
        } else {
            errorphone.setVisible(false);
        }
        return check;
    }
    
    void resertform(){
        txtaddress.setText(null);
        txtfullname.setText(null);
        txtemail.setText(null);
        txtphone.setText(null);
        txtbirthday.setValue(null);
        erroraddress.setVisible(false);
        errorbirthday.setVisible(false);
        errorfullname.setVisible(false);
        erroremail.setVisible(false);
        errorphone.setVisible(false);
    }

    boolean validateform(Librarian librarian){
        boolean check = true;
        if(librarian.getfull_name().equalsIgnoreCase("")||librarian.getfull_name()==null){
            errorfullname.setVisible(true);
            check = false;
        } else {
            errorfullname.setVisible(false);
        }
        if(librarian.getaddress().equalsIgnoreCase("")||librarian.getaddress()==null){
            erroraddress.setVisible(true);
            check = false;
        } else{
            erroraddress.setVisible(false);
        }
        if(librarian.getbirthday().equalsIgnoreCase("")||librarian.getbirthday()==null){
            errorbirthday.setVisible(true);
            check = false;
        } else{
            errorbirthday.setVisible(false);
        }
        if(librarian.getemail().equalsIgnoreCase("")||librarian.getemail()==null){
            erroremail.setVisible(true);
            check = false;
        } else{
            erroremail.setVisible(false);
        }
        if(librarian.getphone_number().equalsIgnoreCase("")||librarian.getphone_number()==null){
            errorphone.setVisible(true);
            check = false;
        } else{
            errorphone.setVisible(false);
        }
        return check;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private boolean validateemail(TextField txtemail) {
        String regex = "^([a-zA-Z0-9_]+)@([a-zA-Z0-9]+)(.[a-zA-Z]{2,6})+$";
        boolean check = Pattern.compile(regex).matcher(!txtemail.getText().isBlank()&&!txtemail.getText().isEmpty()?txtemail.getText():"").matches();
        if(check==false){
            erroremail.setVisible(true);
        } else {
            erroremail.setVisible(false);
        }
        return check;
    }
}
