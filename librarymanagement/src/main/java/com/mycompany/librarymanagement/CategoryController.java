package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.model.Book;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CategoryController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane card;

    @FXML
    private Label category_name;

    @FXML
    private ImageView fisrt_image;

    @FXML
    private Label quantity;

    @FXML
    private ImageView second_image;

    @FXML
    private ImageView third_image;
    
    static String category_name_static;

    static Image fisrt_image_static;

    static String quantity_static;

    static Image second_image_static;

    static Image third_image_static;

    @FXML
    void initialize() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fisrt_image.setImage(fisrt_image_static);
        second_image.setImage(second_image_static);
        third_image.setImage(third_image_static);
        category_name.setText(category_name_static);
        quantity.setText(quantity_static);
    }
    
    @FXML
    void get_list_by_category(MouseEvent event){
        HomepageController.hbox = new HBox();
        HomepageController.vbox = new VBox();
        List<Book> bookdata = BookCRUD.getListByCategoryId(CategoryCRUD.getlistByName(category_name.getText()).get(0).getid());
        for (Book book : bookdata) {
            BookController.author = AuthorCRUD.getlistByID(book.getauthor_id()).get(0).getfull_name();
            BookController.image = new Image(App.class.getResourceAsStream("/img/"+book.getimage()));
            BookController.title = book.gettitle();
            HomepageController.hbox.getChildren().add(getPage("book"));
            if(HomepageController.hbox.getChildren().size()==10){
                HomepageController.vbox.getChildren().add(HomepageController.hbox);
                HomepageController.hbox = new HBox();
            }
        }
        HomepageController.vbox.getChildren().add(HomepageController.hbox);
        HomepageController.bottomscroll.setContent(HomepageController.vbox);
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
