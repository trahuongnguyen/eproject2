package com.mycompany.librarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AddController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane sidepane;
    
    static AnchorPane mainpane;

    @FXML
    void addauthor(MouseEvent event) {
        Pane view = getPage("addauthor");
        HomepageController.navpanestatic.setCenter(view);
    }

    @FXML
    void addcollection(MouseEvent event) {
        Pane view = getPage("addcollection");
        HomepageController.navpanestatic.setCenter(view);
    }

    @FXML
    void additem(MouseEvent event) {
        Pane view = getPage("additem");
        HomepageController.navpanestatic.setCenter(view);
    }

    @FXML
    void addpublisher(MouseEvent event) {
        Pane view = getPage("addpublisher");
        HomepageController.navpanestatic.setCenter(view);
    }
    
    @FXML
    void addborrow(MouseEvent event) {
        Pane view = getPage("addborrow");
        HomepageController.navpanestatic.setCenter(view);
    }
    
    @FXML
    void addlibrarian(MouseEvent event) {
        Pane view = getPage("addlibrarian");
        HomepageController.navpanestatic.setCenter(view);
    }
    
    @FXML
    void addmember(MouseEvent event) {
        Pane view = getPage("addmember");
        HomepageController.navpanestatic.setCenter(view);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainpane = sidepane;
    }
}
