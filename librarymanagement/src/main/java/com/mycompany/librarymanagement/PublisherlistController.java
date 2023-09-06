package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.PublisherCRUD;
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
import javafx.util.Callback;

public class PublisherlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Publisher, String> publishername;

    @FXML
    private TableView publishertable;

    @FXML
    private TableColumn<Publisher, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Publisher> dataList = PublisherCRUD.getlist();
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
}
