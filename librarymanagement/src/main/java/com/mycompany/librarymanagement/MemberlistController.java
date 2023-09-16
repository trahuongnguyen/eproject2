package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.MemberCRUD;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Member;
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
    private TableView<Member> membertable;

    @FXML
    private TableColumn<Member, String> phonenumber;

    @FXML
    private TableColumn<Member, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
    
    void initialize(){
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
    
    @FXML
    private DatePicker duedatetxt;
    
    @FXML
    private AnchorPane formvisible;
    
    static Member member;
    
    void resetform(){
        fullnametxt.setText(null);
        addresstxt.setText(null);
        phonetxt.setText(null);
        emailtxt.setText(null);
        birthdaytxt.setValue(null);
        duedatetxt.setValue(null);
        formvisible.setVisible(false);
    }
    
    @FXML
    void display_selected_item(MouseEvent event){
        member = membertable.getSelectionModel().getSelectedItem();
        if(member!=null){
            formvisible.setVisible(true);
            fullnametxt.setText(member.getfull_name());
            addresstxt.setText(member.getaddress());
            phonetxt.setText(member.getphone_number());
            emailtxt.setText(member.getemail());
            birthdaytxt.setValue(LocalDate.parse(member.getbirthday()));
            duedatetxt.setValue(LocalDate.parse(member.getdue_date()));
        }
    }
    
    @FXML
    void update(MouseEvent event){
        member = new Member(
                member.getid(), 
                fullnametxt.getText().isBlank()==false?fullnametxt.getText():member.getfull_name(), 
                addresstxt.getText().isBlank()==false?addresstxt.getText():member.getaddress(), 
                phonetxt.getText().isBlank()==false?phonetxt.getText():member.getphone_number(), 
                birthdaytxt.getValue()!=null?birthdaytxt.getValue().getYear() + "-" + birthdaytxt.getValue().getMonthValue() + "-" + birthdaytxt.getValue().getDayOfMonth():member.getbirthday(), 
                emailtxt.getText().isBlank()==false?emailtxt.getText():member.getemail(), 
                duedatetxt.getValue()!=null?duedatetxt.getValue().getYear() + "-" + duedatetxt.getValue().getMonthValue() + "-" + duedatetxt.getValue().getDayOfMonth():member.getdue_date()
        );
        boolean isHave = false;
        List<Member> memberList = MemberCRUD.getList();
        for (Member member1 : memberList) {
            if(member1.getemail().equalsIgnoreCase(member.getemail()) && member1.getid()!=member.getid()){
                isHave = true;
                break;
            }
        }
        if(!isHave){
            MemberCRUD.update(member);
        }
        resetform();
        initialize();
    }
    
    @FXML
    void delete(MouseEvent event){
        if(member!=null){
            List<Borrow> borrowList = BorrowCRUD.getListByMemberId(member.getid());
            for (Borrow borrow : borrowList) {
                BorrowCRUD.delete(borrow.getid());
            }
            MemberCRUD.delete(member.getid());
        }
        resetform();
        initialize();
    }
}
