package com.mycompany.librarymanagement;

import com.jfoenix.controls.JFXButton;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.BorrowInfoCRUD;
import com.mycompany.librarymanagement.crud.LibrarianCRUD;
import com.mycompany.librarymanagement.crud.MemberCRUD;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.BorrowInfo;
import com.mycompany.librarymanagement.model.Librarian;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class BorrowlistController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<BorrowInfo, String> actualdate;
    
    @FXML
    private TableColumn<BorrowInfo, String> note;

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
    private TableView<BorrowInfo> borrowtable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
    void initialize(){
        List<BorrowInfo> dataList = BorrowInfoCRUD.getList();
        ObservableList<BorrowInfo> borrowInfoList = FXCollections.observableArrayList(dataList);
        stt.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new ReadOnlyObjectWrapper(borrowtable.getItems().indexOf(param.getValue())+1));
        
        book.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getProBook());
        
        note.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getBorrow().getProOther_note());
        
        member.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getProMember());
        
        librarian.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> param.getValue().getProLibrarian());
        
        duedate.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getborrow_from_date()+"  -  "+param.getValue().getBorrow().getborrow_to_date()));
        
        actualdate.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getactual_returned_date()));
        
        latefee.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getlate_fee()+""));
        
        borrowfee.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().getborrow_fee()+""));
        
        total.setCellValueFactory((TableColumn.CellDataFeatures<BorrowInfo, String> param) -> new SimpleStringProperty(param.getValue().getBorrow().gettotal()+""));
        
        borrowtable.setItems(borrowInfoList);
    }
    
    @FXML
    private TextField latefeetxt;
    
    @FXML
    private TextField borrowfeetxt;
    
    @FXML
    private ComboBox<String> booktitletxt;
    
    @FXML
    private ComboBox<String> membertxt;
    
    @FXML
    private ComboBox<String> librariantxt;
    
    @FXML
    private DatePicker from;
    
    @FXML
    private DatePicker to;
    
    @FXML
    private DatePicker actualreturned;
    
    @FXML
    private TextArea notetxt;
    
    @FXML
    private AnchorPane formVisible;
    
    @FXML
    private JFXButton update;
    
    @FXML
    private JFXButton delete;
    
    static BorrowInfo borrowInfo;
    static Borrow borrow;
    
    @FXML
    void update(MouseEvent event){
        borrow = new Borrow(
                borrowInfo.getBorrow().getid(), 
                BookCRUD.getListByName(booktitletxt.getValue()!=null?booktitletxt.getValue():borrowInfo.getbook()).get(0).getid(), 
                MemberCRUD.getListByEmail(membertxt.getValue()!=null?membertxt.getValue():borrowInfo.getmember()).get(0).getid(), 
                LibrarianCRUD.getListByEmail(librariantxt.getValue()!=null?librariantxt.getValue():borrowInfo.getlibrarian()).get(0).getid(), 
                from.getValue()!=null?from.getValue().getYear() + "-" + from.getValue().getMonthValue() + "-" + from.getValue().getDayOfMonth():borrowInfo.getBorrow().getborrow_from_date(), 
                to.getValue()!=null?to.getValue().getYear() + "-" + to.getValue().getMonthValue() + "-" + to.getValue().getDayOfMonth():borrowInfo.getBorrow().getborrow_to_date(), 
                actualreturned.getValue()!=null?actualreturned.getValue().getYear() + "-" + actualreturned.getValue().getMonthValue() + "-" + actualreturned.getValue().getDayOfMonth():borrowInfo.getBorrow().getactual_returned_date(), 
                notetxt.getText()!=null?notetxt.getText():"", 
                validatenumber(latefeetxt)?Float.parseFloat(latefeetxt.getText()):0, 
                validatenumber(borrowfeetxt)?Float.parseFloat(borrowfeetxt.getText()):borrowInfo.getBorrow().getborrow_fee(), 
                validatenumber(latefeetxt)&& validatenumber(borrowfeetxt)?Float.parseFloat(latefeetxt.getText()) + Float.parseFloat(borrowfeetxt.getText()):borrowInfo.getBorrow().gettotal()
        );
        BorrowCRUD.update(borrow, borrowInfo.getBorrow().getid());
        initialize();
        resetform();
        
    }
    
    boolean validatenumber(TextField text){
        float n;
        if(text.getText()==null){
            return false;
        }
        try {
            n = Float.parseFloat(text.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    void resetform(){
        booktitletxt.setValue(null);
        membertxt.setValue(null);
        librariantxt.setValue(null);
        from.setValue(null);
        to.setValue(null);
        actualreturned.setValue(null);
        latefee.setText(null);
        borrowfeetxt.setText(null);
        notetxt.setText(null);
        formVisible.setVisible(false);
    }
    
    @FXML
    void delete(MouseEvent event){
        BorrowCRUD.delete(borrowInfo.getBorrow().getid());
        resetform();
        initialize();
    }

    @FXML
    void displaySeletedItem(MouseEvent event){
        if(borrowtable.getSelectionModel().getSelectedItem()!=null){
            borrowInfo = borrowtable.getSelectionModel().getSelectedItem();
            borrow = borrowInfo.getBorrow();
            formVisible.setVisible(true);
            List<Book> bookList = BookCRUD.getList();
            for (Book book1 : bookList) {
                booktitletxt.getItems().add(book1.gettitle());
            }
            List<Member> memberList = MemberCRUD.getList();
            for (Member member1 : memberList) {
                membertxt.getItems().add(member1.getemail());
            }
            List<Librarian> librarianList = LibrarianCRUD.getList();
            for (Librarian librarian1 : librarianList) {
                librariantxt.getItems().add(librarian1.getemail());
            }
            booktitletxt.setValue(borrowInfo.getbook());
            membertxt.setValue(borrowInfo.getmember());
            librariantxt.setValue(borrowInfo.getlibrarian());
            from.setValue(LocalDate.parse(borrow.getborrow_from_date()));
            to.setValue(LocalDate.parse(borrow.getborrow_to_date()));
            actualreturned.setValue(LocalDate.parse(borrow.getactual_returned_date()));
            latefeetxt.setText(borrow.getlate_fee()+"");
            borrowfeetxt.setText(borrow.getborrow_fee()+"");
            notetxt.setText(borrow.getother_note());
        }
    }
}
