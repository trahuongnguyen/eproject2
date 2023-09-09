package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.model.Category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddcollectionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addcollection_btn;
    
    @FXML
    private TextField collectiontitle;
    
    @FXML
    private TextField locatedin;
    
    @FXML
    private ImageView titleerror;
    
    @FXML
    private ImageView locatederror;
    
    private Category category;
    
    boolean validateform(){
        String error = null;
        if(category.gettitle().equalsIgnoreCase("")){
            error = "collection is null";
            titleerror.setVisible(true);
        }
        if(category.getlocated_in().equalsIgnoreCase("")){
            error = "located is null";
            locatederror.setVisible(true);
        }
        return error==null;
    }
    
    @FXML
    void addcollection(MouseEvent event){
        category = new Category(
                0, 
                !collectiontitle.getText().isEmpty()?collectiontitle.getText():"", 
                !locatedin.getText().isEmpty()?locatedin.getText():""
        );
        if(validateform()){
            CategoryCRUD.insert(category);
        }
    }
}
