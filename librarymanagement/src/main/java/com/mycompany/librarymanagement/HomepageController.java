package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Category;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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

    static List<Category> categoryList = CategoryCRUD.getlist();
    static HBox hbox;
    static VBox vbox;
    static ScrollPane bottomscroll;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainpanestatic = mainpane;
        navpanestatic = navpane;
        Pane pane = getPage("list");
        navpane.setLeft(pane);
        List<Book> dataBook = BookCRUD.getList();
        hbox = new HBox();
        vbox = new VBox();
        for (Book book : dataBook) {
            BookController.author = AuthorCRUD.getlistByID(book.getauthor_id()).get(0).getfull_name();
            BookController.image = new Image(App.class.getResourceAsStream("/img/"+book.getimage()));
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
        for (Category category : categoryList) {
            CategoryController.category_name_static = category.gettitle();
            List<Book> bookList = BookCRUD.getListByCategoryId(category.getid());
            CategoryController.fisrt_image_static = new Image(App.class.getResourceAsStream("/img/" + bookList.get(0).getimage()));
            CategoryController.second_image_static = new Image(App.class.getResourceAsStream("/img/" + bookList.get(1).getimage()));
            CategoryController.third_image_static = new Image(App.class.getResourceAsStream("/img/" + bookList.get(2).getimage()));
            CategoryController.quantity_static = "Quantity: "+bookList.size();
            hbox2.getChildren().add(getPage("category"));
        }
        toplayout.setContent(hbox2);
        bottomscroll = bottomlayout;
    }
    
    @FXML
    private ScrollPane toplayout;
    
    @FXML
    private ScrollPane bottomlayout;
}
