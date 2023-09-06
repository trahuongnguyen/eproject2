package com.mycompany.librarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdditemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button additem_btn;

    @FXML
    void initialize() {
        assert additem_btn != null : "fx:id=\"additem_btn\" was not injected: check your FXML file 'additem.fxml'.";

    }

}
