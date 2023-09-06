package com.mycompany.librarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane sidepane;

    @FXML
    void addauthor(MouseEvent event) {
        Pane view = getPage("addauthor");
        sidepane.setCenter(view);
    }

    @FXML
    void addcollection(MouseEvent event) {
        Pane view = getPage("addcollection");
        sidepane.setCenter(view);
    }

    @FXML
    void additem(MouseEvent event) {
        Pane view = getPage("additem");
        sidepane.setCenter(view);
    }

    @FXML
    void addpublisher(MouseEvent event) {
        Pane view = getPage("addpublisher");
        sidepane.setCenter(view);
    }
    
    @FXML
    void addborrow(MouseEvent event) {
        Pane view = getPage("addborrow");
        sidepane.setCenter(view);
    }
    
    @FXML
    void addlibrarian(MouseEvent event) {
        Pane view = getPage("addlibrarian");
        sidepane.setCenter(view);
    }
    
    @FXML
    void addmember(MouseEvent event) {
        Pane view = getPage("addmember");
        sidepane.setCenter(view);
    }

    public Pane view;

    public Pane getPage(String fileName) {

        try {
            URL fileURL = App.class.getResource(fileName + ".fxml");
            if (fileURL == null) {
                throw new java.io.FileNotFoundException("FXML can't be found");
            }
            view = FXMLLoader.load(fileURL);
        } catch (IOException e) {
            System.out.println("No page " + fileName + "please check FxmlLoader");
        }
        return view;
    }
}
