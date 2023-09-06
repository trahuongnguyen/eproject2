package com.mycompany.librarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane sidepane;

    @FXML
    void authorlist(MouseEvent event) {
        Pane view = getPage("authorlist");
        sidepane.setCenter(view);
    }
    
    @FXML
    void borrowlist(MouseEvent event) {
        Pane view = getPage("borrowlist");
        sidepane.setCenter(view);
    }
    
    @FXML
    void librarianlist(MouseEvent event) {
        Pane view = getPage("librarianlist");
        sidepane.setCenter(view);
    }
    
    @FXML
    void memberlist(MouseEvent event) {
        Pane view = getPage("memberlist");
        sidepane.setCenter(view);
    }

    @FXML
    void collectionlist(MouseEvent event) {
        Pane view = getPage("collectionlist");
        sidepane.setCenter(view);
    }

    @FXML
    void itemlist(MouseEvent event) {
        Pane view = getPage("itemlist");
        sidepane.setCenter(view);
    }

    @FXML
    void publisherlist(MouseEvent event) {
        Pane view = getPage("publisherlist");
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