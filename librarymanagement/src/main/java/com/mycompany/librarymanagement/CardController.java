package com.mycompany.librarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CardController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label authorname;

    @FXML
    private Label booktitle;

    @FXML
    private HBox box;

    @FXML
    private ImageView imagebook;
    
    static Image image; 
    static String title;
    static String author;

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imagebook.setImage(image);
        booktitle.setText(title);
        authorname.setText(author);
    }

}
