package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.LibrarianCRUD;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Librarian;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private TableView<Librarian> librariantable;

    @FXML
    private TableColumn<Librarian, String> phonenumber;

    @FXML
    private TableColumn<Librarian, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Librarian> datList = LibrarianCRUD.getList();
        ObservableList<Librarian> librarianList = FXCollections.observableArrayList(datList);
        
        address.setCellValueFactory((TableColumn.CellDataFeatures<Librarian, String> param) -> param.getValue().getProAddress());
        
        birthday.setCellValueFactory((TableColumn.CellDataFeatures<Librarian, String> param) -> new SimpleStringProperty(param.getValue().getbirthday()));
        
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
        
        phonenumber.setCellValueFactory((TableColumn.CellDataFeatures<Librarian, String> param) -> param.getValue().getProPhone_number());
        
        stt.setCellValueFactory((TableColumn.CellDataFeatures<Librarian, String> param) -> new ReadOnlyObjectWrapper(librariantable.getItems().indexOf(param.getValue())+1));
        
        librariantable.setItems(librarianList);
    }
    
    @FXML
    private TextField fullnametxt;
    
    @FXML
    private TextField addresstxt;
    
    @FXML
    private TextField phonetxt;
    
    @FXML
    private TextField emailtxt;
    
    @FXML
    private DatePicker birthdaytxt;
    
    static Librarian librarian;
    
    @FXML
    private AnchorPane formvisible;
    
    @FXML
    void display_selected_item(MouseEvent event){
        librarian = librariantable.getSelectionModel().getSelectedItem();
        if(librarian != null){
            formvisible.setVisible(true);
            fullnametxt.setText(librarian.getfull_name());
            addresstxt.setText(librarian.getaddress());
            phonetxt.setText(librarian.getphone_number());
            emailtxt.setText(librarian.getemail());
            birthdaytxt.setValue(LocalDate.parse(librarian.getbirthday()));
        }
    }
    
    @FXML
    void update(MouseEvent event){
        librarian = new Librarian(
                librarian.getid(), 
                fullnametxt.getText().isBlank()==false?fullnametxt.getText():librarian.getfull_name(), 
                addresstxt.getText().isBlank()==false?emailtxt.getText():librarian.getaddress(), 
                phonetxt.getText().isBlank()==false?phonetxt.getText():librarian.getphone_number(),
                birthdaytxt.getValue()!=null?birthdaytxt.getValue().getYear()+"-"+birthdaytxt.getValue().getMonthValue()+"-"+birthdaytxt.getValue().getDayOfMonth():librarian.getbirthday(), 
                emailtxt.getText().isBlank()==false?emailtxt.getText():librarian.getemail()
        );
        LibrarianCRUD.update(librarian);
        resetform();
    }
    
    void resetform(){
        fullnametxt.setText(null);
        addresstxt.setText(null);
        phonetxt.setText(null);
        birthdaytxt.setValue(null);
        emailtxt.setText(null);
        formvisible.setVisible(false);
    }
    
    @FXML
    void delete(MouseEvent event){
        List<Librarian> librarianList = LibrarianCRUD.getListByEmail(librarian.getemail());
        for (Librarian librarian1 : librarianList) {
            List<Borrow> borrowList = BorrowCRUD.getListByLibrarianId(librarian1.getid());
            for (Borrow borrow : borrowList) {
                BorrowCRUD.delete(borrow.getid());
            }
            LibrarianCRUD.delete(librarian1.getid());
        }
        resetform();
    }
}
