package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.CategoryCRUD;
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
    private TableView collectiontable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Category> dataList = CategoryCRUD.getlist();
        ObservableList<Category> categoryList = FXCollections.observableArrayList(dataList);
        
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Category, String> param) {
                return new ReadOnlyObjectWrapper(collectiontable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        categoryname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Category, String> param) {
                return param.getValue().getProTitle();
            }
        });
        
        located_in.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Category, String> param) {
                return param.getValue().getProLocated_in();
            }
        });
        
        collectiontable.setItems(categoryList);
    }
}
