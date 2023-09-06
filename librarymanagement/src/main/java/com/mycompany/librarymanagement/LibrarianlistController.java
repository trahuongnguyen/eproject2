package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.LibrarianCRUD;
import com.mycompany.librarymanagement.model.Librarian;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class LibrarianlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Librarian, String> address;

    @FXML
    private TableColumn<Librarian, String> birthday;

    @FXML
    private TableColumn<Librarian, String> email;

    @FXML
    private TableColumn<Librarian, String> fullname;

    @FXML
    private TableView librariantable;

    @FXML
    private TableColumn<Librarian, String> phonenumber;

    @FXML
    private TableColumn<Librarian, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Librarian> datList = LibrarianCRUD.getList();
        ObservableList<Librarian> librarianList = FXCollections.observableArrayList(datList);
        
        address.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return param.getValue().getProAddress();
            }
        });
        
        birthday.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return new SimpleStringProperty(param.getValue().getbirthday());
            }
        });
        
        email.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return param.getValue().getProEmail();
            }
        });
        
        fullname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return param.getValue().getProFull_name();
            }
        });
        
        phonenumber.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return param.getValue().getProPhone_number();
            }
        });
        
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Librarian, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Librarian, String> param) {
                return new ReadOnlyObjectWrapper(librariantable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        librariantable.setItems(librarianList);
    }
}
