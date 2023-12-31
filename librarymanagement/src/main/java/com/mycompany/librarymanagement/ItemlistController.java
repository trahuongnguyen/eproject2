package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BookInfoCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.crud.PublisherCRUD;
import com.mycompany.librarymanagement.model.Author;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.BookInfo;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Category;
import com.mycompany.librarymanagement.model.Publisher;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ItemlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<BookInfo, String> publishername;

    @FXML
    private TableColumn<BookInfo, String> booktitle;

    @FXML
    private TableColumn<BookInfo, String> language;

    @FXML
    private TableColumn<BookInfo, String> categorytitle;

    @FXML
    private TableColumn<BookInfo, String> authorname;

    @FXML
    private TableColumn<BookInfo, String> quantity;
    
    @FXML
    private TableColumn<BookInfo, String> image;

    @FXML
    private TableColumn<BookInfo, String> lostorbroken;

    @FXML
    private TableColumn<BookInfo, String> stt;

    @FXML
    private TableView<BookInfo> itemtable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
    
    void initialize(){
        List<BookInfo> dataList = BookInfoCRUD.getList();
        ObservableList<BookInfo> bookList = FXCollections.observableArrayList(dataList);
        
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return new ReadOnlyObjectWrapper(itemtable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        publishername.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return param.getValue().getProPublisher();
            }
        });
        
        booktitle.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return param.getValue().getBook().getProTitle();
            }
        });
        
        language.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return param.getValue().getBook().getProLanguage();
            }
        });
        
        categorytitle.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return param.getValue().getProCategory();
            }
        });
        
        authorname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return param.getValue().getProAuthor();
            }
        });
        
        quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBook().getquantity()+"");
            }
        });
        
        lostorbroken.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBook().getlost_or_broken()+"");
            }
        });
        
        image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBook().getimage());
            }
        });
        
        itemtable.setItems(bookList);
    }
    
    @FXML
    private ComboBox<String> choosecategory;
    
    @FXML
    private ComboBox<String> choosepublisher;
    
    @FXML
    private ComboBox<String> chooseauthor;
    
    @FXML
    private TextField txtbooktitle;
    
    @FXML
    private TextField txtimage;
    
    @FXML
    private TextField txtlost_or_broken;
    
    @FXML
    private TextField txtquantity;
    
    @FXML
    private AnchorPane formvisible;
    
    @FXML
    private TextField txtlanguage;
    
    static Book book;
    
    @FXML
    void updateitem(MouseEvent event){
        Book bo = new Book(
                book.getid(), 
                !txtbooktitle.getText().equalsIgnoreCase("")&&!txtbooktitle.getText().isEmpty()?txtbooktitle.getText():itemtable.getSelectionModel().getSelectedItem().getBook().gettitle(), 
                choosecategory.getValue()!=null?CategoryCRUD.getlistByName(choosecategory.getValue()).get(0).getid():itemtable.getSelectionModel().getSelectedItem().getBook().getcategory_id(), 
                choosepublisher.getValue()!=null?PublisherCRUD.getlistByName(choosepublisher.getValue()).get(0).getid():itemtable.getSelectionModel().getSelectedItem().getBook().getpublisher_id(), 
                !txtlanguage.getText().equalsIgnoreCase("")&&!txtlanguage.getText().isEmpty()?txtlanguage.getText():itemtable.getSelectionModel().getSelectedItem().getBook().getlanguage(), 
                chooseauthor.getValue()!=null?AuthorCRUD.getlistByName(chooseauthor.getValue()).get(0).getid():itemtable.getSelectionModel().getSelectedItem().getBook().getauthor_id(), 
                validateform(txtquantity)?Integer.parseInt(txtquantity.getText()):itemtable.getSelectionModel().getSelectedItem().getBook().getquantity(), 
                validateform(txtlost_or_broken)?Integer.parseInt(txtlost_or_broken.getText()):itemtable.getSelectionModel().getSelectedItem().getBook().getlost_or_broken(), 
                !txtimage.getText().equalsIgnoreCase("")?txtimage.getText():itemtable.getSelectionModel().getSelectedItem().getBook().getimage()
        );
        BookCRUD.update(bo, book.getid());
        resetform();
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
    
    void resetform(){
        txtbooktitle.setText(null);
        choosecategory.setValue(null);
        choosepublisher.setValue(null);
        txtlanguage.setText(null);
        chooseauthor.setValue(null);
        txtquantity.setText(null);
        txtlost_or_broken.setText(null);
        txtimage.setText(null);
        formvisible.setVisible(false);
    }
    
    @FXML
    void deleteitem(MouseEvent event){
        List<Borrow> borrowList = BorrowCRUD.getListByBookId(book.getid());
        if(borrowList.size()>0){
            for (Borrow borrow : borrowList) {
                BorrowCRUD.delete(borrow.getid());
            }
        }
        BookCRUD.deleteBook(book.getid());
        resetform();
        initialize();
    }
    
    boolean validateform(TextField txt){
        int num;
        try {
            num = Integer.parseInt(txt.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    @FXML
    void displaySeletedItem(MouseEvent event){
        BookInfo b = itemtable.getSelectionModel().getSelectedItem();
        if(b!=null){
            List<Book> itemList = BookCRUD.getListById(b.getBook().getid());
            book = new Book(
                    itemList.get(0).getid(), 
                    b.getBook().gettitle(), 
                    b.getBook().getcategory_id(), 
                    b.getBook().getpublisher_id(), 
                    b.getBook().getlanguage(), 
                    b.getBook().getauthor_id(), 
                    b.getBook().getquantity(), 
                    b.getBook().getlost_or_broken(), 
                    b.getBook().getimage()+""
            );
            
            formvisible.setVisible(true);
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
            
            txtbooktitle.setText(b.getBook().gettitle());
            choosecategory.setValue(b.getcategory());
            choosepublisher.setValue(b.getpublisher());
            txtlanguage.setText(b.getBook().getlanguage());
            chooseauthor.setValue(b.getauthor());
            txtquantity.setText(b.getBook().getquantity()+"");
            txtlost_or_broken.setText(b.getBook().getlost_or_broken()+"");
            txtimage.setText(b.getBook().getimage()+"");
        }
    }
}
