package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.PublisherCRUD;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Publisher;
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

public class PublisherlistController implements Initializable{

    @FXML
    private ResourceBundle resources;   

    @FXML
    private URL location;

    @FXML
    private TableColumn<Publisher, String> publishername;

    @FXML
    private TableView<Publisher> publishertable;

    @FXML
    private TableColumn<Publisher, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
    
    void initialize(){
        dataList = PublisherCRUD.getlist();
        ObservableList<Publisher> publsherList = FXCollections.observableArrayList(dataList);
        
        publishername.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Publisher, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Publisher, String> param) {
                return param.getValue().getProName();
            }
        });
        
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Publisher, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Publisher, String> param) {
                return new ReadOnlyObjectWrapper(publishertable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        publishertable.setItems(publsherList);
    }
    
    @FXML
    private TextField txtpublisher;
    
    @FXML
    private AnchorPane formvisible;
    
    static Publisher publisher;
    static List<Publisher> dataList;
    
    @FXML
    void display_selected_item(MouseEvent event){
        publisher = publishertable.getSelectionModel().getSelectedItem();
        if(publisher!=null){
            formvisible.setVisible(true);
            txtpublisher.setText(publisher.getname());
        }
    }
    
    @FXML
    void update(MouseEvent event){
        publisher = new Publisher(publisher.getid(), txtpublisher.getText().isBlank()==false?txtpublisher.getText():publisher.getname());
        boolean isHave = false;
        for (Publisher publisher1 : dataList) {
            if(publisher1.getname().equalsIgnoreCase(publisher.getname()) && publisher1.getid()!=publisher.getid()){
                isHave = true;
            }
        }
        if(!isHave){
            PublisherCRUD.update(publisher);
            initialize();
        }
        resetform();
    }
    
    @FXML
    void delete(MouseEvent event){
        if(publisher!=null){
            List<Book> bookList = BookCRUD.getListByPublisherId(publisher.getid());
            for (Book book : bookList) {
                List<Borrow> borrowList = BorrowCRUD.getListByBookId(book.getid());
                for (Borrow borrow : borrowList) {
                    BorrowCRUD.delete(borrow.getid());
                }
                BookCRUD.deleteBook(book.getid());
            }
            PublisherCRUD.delete(publisher.getid());
            initialize();
        }
        resetform();
    }
    
    void resetform(){
        txtpublisher.setText(null);
        formvisible.setVisible(false);
    }
}
