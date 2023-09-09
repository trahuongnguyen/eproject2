package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.PublisherCRUD;
import com.mycompany.librarymanagement.model.Publisher;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddpublisherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addpublisher_btn;

    @FXML
    private ImageView errorpublisher;

    @FXML
    private TextField publishernametxt;
    
    static Publisher publisher;

    @FXML
    void addpublisher(MouseEvent event) {
        publisher = new Publisher(0, !publishernametxt.getText().isEmpty()&&publishernametxt.getText().isBlank()?publishernametxt.getText():"");
        if(validateform()){
            List<Publisher> publisherList = PublisherCRUD.getlist();
            boolean isHave = false;
            if(publisherList.size()<=0){
                PublisherCRUD.insert(publisher);
            } else{
                for (Publisher publisher1 : publisherList) {
                    if(publisher.getname().equalsIgnoreCase(publisher1.getname())){
                        isHave = true;
                        resetform();
                        break;
                    }
                }
                if(!isHave){
                    PublisherCRUD.insert(publisher);
                    resetform();
                }
            }
        }
    }

    @FXML
    void initialize() {
        
    }
    
    boolean validateform(){
        boolean check = true;
        if(publisher.getname().equalsIgnoreCase("")){
            errorpublisher.setVisible(true);
            check = false;
        } else{
            errorpublisher.setVisible(false);
        }
        return check;
    }

    private void resetform() {
        publishernametxt.setText(null);
        errorpublisher.setVisible(false);
    }

}
