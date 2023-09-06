package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BookInfoCRUD;
import com.mycompany.librarymanagement.model.BookInfo;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<BookInfo, String> lostorbroken;

    @FXML
    private TableColumn<BookInfo, String> stt;

    @FXML
    private TableView itemtable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                return new SimpleStringProperty(param.getValue().getBook().getProQuantity()+"");
            }
        });
        
        lostorbroken.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BookInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BookInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBook().getProLost_or_broken()+"");
            }
        });
        
        itemtable.setItems(bookList);
    }
}
