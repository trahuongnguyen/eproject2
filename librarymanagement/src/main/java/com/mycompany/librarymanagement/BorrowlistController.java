package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BorrowInfoCRUD;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.BorrowInfo;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class BorrowlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<BorrowInfo, String> actualdate;

    @FXML
    private TableColumn<BorrowInfo, String> book;

    @FXML
    private TableColumn<BorrowInfo, String> borrowfee;

    @FXML
    private TableColumn<BorrowInfo, String> duedate;

    @FXML
    private TableColumn<BorrowInfo, String> latefee;

    @FXML
    private TableColumn<BorrowInfo, String> librarian;

    @FXML
    private TableColumn<BorrowInfo, String> member;

    @FXML
    private TableColumn<BorrowInfo, String> stt;

    @FXML
    private TableColumn<BorrowInfo, String> total;
    
    @FXML
    private TableView borrowtable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<BorrowInfo> dataList = BorrowInfoCRUD.getList();
        ObservableList<BorrowInfo> borrowInfoList = FXCollections.observableArrayList(dataList);
        stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BorrowInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BorrowInfo, String> param) {
                return new ReadOnlyObjectWrapper(borrowtable.getItems().indexOf(param.getValue())+1);
            }
        });
        
        book.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getProBook());
        
        member.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getProMember());
        
        librarian.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BorrowInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BorrowInfo, String> param) {
                return param.getValue().getProLibrarian();
            }
        });
        
        duedate.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getborrow_from_date()+"  -  "+param.getValue().getBorrow().getborrow_to_date()));
        
        actualdate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BorrowInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BorrowInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBorrow().getactual_returned_date());
            }
        });
        
        latefee.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getlate_fee()+""));
        
        borrowfee.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getborrow_fee()+""));
        
        total.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BorrowInfo, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BorrowInfo, String> param) {
                return new SimpleStringProperty(param.getValue().getBorrow().gettotal()+"");
            }
        });
        
        borrowtable.setItems(borrowInfoList);
    }
}
