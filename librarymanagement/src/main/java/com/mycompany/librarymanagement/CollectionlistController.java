package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.CategoryCRUD;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Category;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class CollectionlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Category, String> categoryname;
    
    @FXML
    private TableColumn<Category, String> located_in;

    @FXML
    private TableColumn<Category, String> stt;
    
    @FXML
    private TableView<Category> collectiontable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
    
    static List<Category> dataList;
    
    void initialize(){
        dataList = CategoryCRUD.getlist();
        ObservableList<Category> categoryList = FXCollections.observableArrayList(dataList);
        
        stt.setCellValueFactory((TableColumn.CellDataFeatures<Category, String> param) -> new ReadOnlyObjectWrapper(collectiontable.getItems().indexOf(param.getValue())+1));
        
        categoryname.setCellValueFactory((TableColumn.CellDataFeatures<Category, String> param) -> param.getValue().getProTitle());
        
        located_in.setCellValueFactory((TableColumn.CellDataFeatures<Category, String> param) -> param.getValue().getProLocated_in());
        
        collectiontable.setItems(categoryList);
    }
    
    @FXML
    private AnchorPane formvisible;
    
    @FXML
    private TextField categorytxt;
    
    @FXML
    private TextField locatedtxt;
    
    static Category category;
    
    @FXML
    void update(MouseEvent event){
        category = new Category(
                category.getid(),
                categorytxt.getText().isBlank()==false?categorytxt.getText():category.gettitle(), 
                locatedtxt.getText().isBlank()==false?locatedtxt.getText():category.getlocated_in()
        );
        boolean isHave = false;
        for (Category category1 : dataList) {
            if(category1.gettitle().equalsIgnoreCase(category.gettitle())){
                isHave = true;
                resetform();
                break;
            }
        }
        
        if(!isHave){
            CategoryCRUD.update(category);
            resetform();
        }
        initialize();
    }
    
    @FXML
    void delete(MouseEvent event){
        category = null;
        category = collectiontable.getSelectionModel().getSelectedItem();
        if(category!=null){
            List<Book> bookList = BookCRUD.getListByCategoryId(category.getid());
            for (Book book : bookList) {
                List<Borrow> borrowList = BorrowCRUD.getListByBookId(book.getid());
                for (Borrow borrow : borrowList) {
                    BorrowCRUD.delete(borrow.getid());
                }
                BookCRUD.deleteBook(book.getid());
            }
            CategoryCRUD.delete(category.getid());
            resetform();
        }
        initialize();
    }
    
    void resetform(){
        categorytxt.setText(null);
        locatedtxt.setText(null);
        formvisible.setVisible(false);
    }
    
    @FXML
    void display_selected_item(MouseEvent event){
        category = collectiontable.getSelectionModel().getSelectedItem();
        if(category!=null){
            formvisible.setVisible(true);
            categorytxt.setText(category.gettitle());
            locatedtxt.setText(category.getlocated_in());
        }
    }
}
