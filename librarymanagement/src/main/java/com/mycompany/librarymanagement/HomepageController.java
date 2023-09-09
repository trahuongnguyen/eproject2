package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.model.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomepageController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane mainpane;
    
    @FXML
    private BorderPane navpane;

    static BorderPane mainpanestatic;
    static BorderPane navpanestatic;

    @FXML
    void add(MouseEvent event) {
        Pane view = getPage("add");
        navpane.setLeft(view);
    }

    @FXML
    void changepassword(MouseEvent event) {
        Pane view = getPage("changepassword");
        navpane.setCenter(view);
    }

    @FXML
    void homepage(MouseEvent event) throws IOException {
        App.setRoot("homepage");
    }

    @FXML
    void list(MouseEvent event) {
        Pane view = getPage("list");
        navpane.setLeft(view);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        App.setRoot("login");
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
        mainpanestatic = mainpane;
        navpanestatic = navpane;
        Pane pane = getPage("list");
        navpane.setLeft(pane);
        List<Book> dataBook = BookCRUD.getList();
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        for (Book book : dataBook) {
            BookController.author = AuthorCRUD.getlistByID(book.getauthor_id()).get(0).getfull_name();
            try {
                BookController.image = new Image(new FileInputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\project\\eproject2\\librarymanagement\\target\\classes\\img\\"+book.getimage()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("not found");
            }
            BookController.title = book.gettitle();
            hbox.getChildren().add(getPage("book"));
            if(hbox.getChildren().size()==10){
                vbox.getChildren().add(hbox);
                hbox = new HBox();
            }
        }
        vbox.getChildren().add(hbox);
        bottomlayout.setContent(vbox);
        HBox hbox2 = new HBox();
        for (int i = dataBook.size(); i > 0; i--) {
            CardController.author = AuthorCRUD.getlistByID(dataBook.get(i-1).getauthor_id()).get(0).getfull_name();
            try {
                CardController.image = new Image(new FileInputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\project\\eproject2\\librarymanagement\\target\\classes\\img\\"+dataBook.get(i-1).getimage()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("not found");
            }
            CardController.title = dataBook.get(i-1).gettitle();
            hbox2.getChildren().add(getPage("card"));
        }
        toplayout.setContent(hbox2);
    }
    
    @FXML
    private ScrollPane toplayout;
    
    @FXML
    private ScrollPane bottomlayout;
}
