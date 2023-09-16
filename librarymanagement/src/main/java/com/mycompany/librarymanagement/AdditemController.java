package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.crud.PublisherCRUD;
import com.mycompany.librarymanagement.model.Author;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Category;
import com.mycompany.librarymanagement.model.Publisher;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AdditemController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button additem_btn;

    @FXML
    private ComboBox<String> chooseauthor;

    @FXML
    private ComboBox<String> choosecategory;

    @FXML
    private ComboBox<String> choosepublisher;

    @FXML
    private TextField txtlanguage;

    @FXML
    private TextField txtquantity;

    @FXML
    private TextField txttitle;
    
    @FXML
    private ImageView errortitle;
    
    @FXML
    private ImageView errorcategory;
    
    @FXML
    private ImageView errorpublisher;
    
    @FXML
    private ImageView errorlanguage;
    
    @FXML
    private ImageView errorauthor;
    
    @FXML
    private ImageView errorquantity;
    
    boolean validatenumber(TextField txt){
        int n;
        try {
            n = Integer.parseInt(txt.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    String validateimage(TextField txt){
        String path = null;
        List<Integer> indexList = new ArrayList<>();
        if(!txt.getText().isBlank()&&!txt.getText().isEmpty()){
            int index = 0;
            while (true) {  
                index = txt.getText().indexOf("\\", index+1);
                if(index<0){
                    break;
                }
                indexList.add(index);
            }
            if(indexList.size()>=2){
                path = txt.getText().substring(indexList.get(indexList.size()-2)+1,indexList.get(indexList.size()-1))+"/"+txt.getText().substring(indexList.get(indexList.size()-1)+1);
            }
        }
        return path;
    }
    
    boolean validateBook(Book book){
        boolean check = true;
        if(book.gettitle().equalsIgnoreCase("")||book.gettitle()==null){
            errortitle.setVisible(true);
            check = false;
        } else {
            errortitle.setVisible(false);
        }
        if(book.getcategory_id()<=0){
            errorcategory.setVisible(true);
            check = false;
        } else {
            errorcategory.setVisible(false);
        }
        if(book.getpublisher_id()<=0){
            errorpublisher.setVisible(true);
            check = false;
        } else {
            errorpublisher.setVisible(false);
        }
        if(book.getlanguage().equalsIgnoreCase("")||book.getlanguage()==null){
            errorlanguage.setVisible(true);
            check = false;
        } else {
            errorlanguage.setVisible(false);
        }
        if(book.getauthor_id()<=0){
            errorauthor.setVisible(true);
            check = false;
        } else {
            errorauthor.setVisible(false);
        }
        if(book.getquantity()<=0){
            errorquantity.setVisible(true);
            check = false;
        } else {
            errorquantity.setVisible(false);
        }
        return check;
    }
    
    void resetform(){
        txttitle.setText(null);
        choosecategory.setValue(null);
        choosepublisher.setValue(null);
        txtlanguage.setText(null);
        chooseauthor.setValue(null);
        txtquantity.setText(null);
        txtimage.setText(null);
    }

    @FXML
    void additem(MouseEvent event) {
        book = new Book(
                0,
                !txttitle.getText().isEmpty()&&!txttitle.getText().isBlank()?txttitle.getText():"",
                choosecategory.getValue()!=null?CategoryCRUD.getlistByName(choosecategory.getValue()).get(0).getid():0,
                choosepublisher.getValue()!=null?PublisherCRUD.getlistByName(choosepublisher.getValue()).get(0).getid():0,
                !txtlanguage.getText().isBlank()&&!txtlanguage.getText().isEmpty()?txtlanguage.getText():"",
                chooseauthor.getValue()!=null?AuthorCRUD.getlistByName(chooseauthor.getValue()).get(0).getid():0,
                validatenumber(txtquantity)?Integer.parseInt(txtquantity.getText()):0,
                0,
                !txtimage.getText().isEmpty()&&!txtimage.getText().isBlank()?txtimage.getText():""
        );
        if(validateBook(book)){
            List<Book> dataList = BookCRUD.getListByName(book.gettitle());
            if(dataList.size()<=0){
                BookCRUD.insert(book);
                resetform();
            } else {
                for (Book book1 : dataList) {
                    if (book.getauthor_id() == book1.getauthor_id()) {
                        if (book1.getlanguage().equalsIgnoreCase(book.getlanguage())) {
                            BookCRUD.update(new Book(
                                    0,
                                    book1.gettitle(),
                                    book1.getcategory_id(),
                                    book1.getpublisher_id(),
                                    book1.getlanguage(),
                                    book1.getauthor_id(),
                                    book1.getquantity() + book.getquantity(),
                                    book1.getlost_or_broken(),
                                    book1.getimage()), book1.getid());
                            resetform();
                            break;
                        } else {
                            BookCRUD.insert(book);
                            resetform();
                            break;
                        }
                    } else {
                        BookCRUD.insert(book);
                        resetform();
                        break;
                    }
                }
            }
        }
    }

    @FXML
    void initialize() {
        List<Category> categoryList = CategoryCRUD.getlist();
        for (Category category : categoryList) {
            choosecategory.getItems().add(category.gettitle());
        }

        List<Publisher> publisherList = PublisherCRUD.getlist();
        for (Publisher publisher : publisherList) {
            choosepublisher.getItems().add(publisher.getname());
        }

        List<Author> authorList = AuthorCRUD.getlist();
        for (Author author : authorList) {
            chooseauthor.getItems().add(author.getfull_name());
        }
    }

    @FXML
    private TextField txtimage;


    static Book book;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }

    @FXML
    void chooseimage(MouseEvent event){
        FileChooser imagechoose = new FileChooser();
        File imageselected = imagechoose.showOpenDialog(new Stage());
        imageselected.getParentFile();
        txtimage.setText(imageselected.getPath());
        if(validateimage(txtimage)!=null){
            txtimage.setText(validateimage(txtimage));
        }
    }
}
