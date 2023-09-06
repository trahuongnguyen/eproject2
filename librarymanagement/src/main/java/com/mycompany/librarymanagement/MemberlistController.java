package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.MemberCRUD;
import com.mycompany.librarymanagement.model.Member;
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

public class MemberlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Member, String> address;

    @FXML
    private TableColumn<Member, String> birthday;

    @FXML
    private TableColumn<Member, String> duedate;

    @FXML
    private TableColumn<Member, String> email;

    @FXML
    private TableColumn<Member, String> fullname;

    @FXML
    private TableView membertable;

    @FXML
    private TableColumn<Member, String> phonenumber;

    @FXML
    private TableColumn<Member, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Member> dataList = MemberCRUD.getList();
        ObservableList<Member> memberList = FXCollections.observableArrayList(dataList);
        
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return new ReadOnlyObjectWrapper(membertable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        fullname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return param.getValue().getProFull_name();
            }
        });
        
        address.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return param.getValue().getProAddress();
            }
        });
        
        birthday.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return new SimpleStringProperty(param.getValue().getbirthday());
            }
        });
        
        phonenumber.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return param.getValue().getProPhone_number();
            }
        });
        
        email.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return param.getValue().getProEmail();
            }
        });
        
        duedate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Member, String> param) {
                return new SimpleStringProperty(param.getValue().getdue_date());
            }
        });
        
        membertable.setItems(memberList);
    }
}
