package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.crud.LibrarianCRUD;
import com.mycompany.librarymanagement.crud.MemberCRUD;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import com.mycompany.librarymanagement.model.Librarian;
import com.mycompany.librarymanagement.model.Member;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddborrowController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker actualdate;

    @FXML
    private Button addborrow_btn;

    @FXML
    private ComboBox<String> booktitle;

    @FXML
    private TextField borrowfee;

    @FXML
    private DatePicker from;

    @FXML
    private TextField latefee;

    @FXML
    private ComboBox<String> librarian;

    @FXML
    private ComboBox<String> member;

    @FXML
    private TextArea note;

    @FXML
    private DatePicker to;

    @FXML
    void addborrow(MouseEvent event) {
        String error = null;
        LocalDate date = LocalDate.now();
        try {
            float late_fee = !latefee.getText().isEmpty()?Float.parseFloat(latefee.getText()):Float.parseFloat("");
        } catch (NumberFormatException e) {
            error = "late fee must be a number format";
        }
        
        try {
            float borrow_fee = !borrowfee.getText().isEmpty()?Float.parseFloat(borrowfee.getText()):Float.parseFloat("");
        } catch (NumberFormatException e) {
            error = "borrow fee must be a number format";
        }
        
        @Deprecated
        Borrow borrow = new Borrow(
                0,
                booktitle.getValue()!=null?BookCRUD.getListByName(booktitle.getValue()).get(0).getid():0,
                member.getValue()!=null?MemberCRUD.getListByEmail(member.getValue()).get(0).getid():0,
                librarian.getValue()!=null?LibrarianCRUD.getListByEmail(librarian.getValue()).get(0).getid():0,
                from.getValue()!=null ? (new Date(from.getValue().getYear(), from.getValue().getMonthValue(), from.getValue().getDayOfMonth()))+"":(new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth()))+"",
                to.getValue()!=null ? new Date(to.getValue().getYear(), to.getValue().getMonthValue(), to.getValue().getDayOfMonth())+"":new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth())+"",
                actualdate.getValue()!=null ? new Date(actualdate.getValue().getYear(), actualdate.getValue().getMonthValue(), actualdate.getValue().getDayOfMonth())+"":new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth())+"",
                note.getText()!=null?note.getText():"",
                !latefee.getText().isEmpty()?Float.parseFloat(latefee.getText()):0,
                !borrowfee.getText().isEmpty()?Float.parseFloat(borrowfee.getText()):0,
                !borrowfee.getText().isEmpty() && !latefee.getText().isEmpty()?Float.parseFloat(latefee.getText()) + Integer.parseInt(borrowfee.getText()):0
        );
        error = null;
        if(borrow.getbook_id()<=0){
            error = "please choose book title";
        }
        if (borrow.getcard_member_id()<=0) {
            error = "please choose card member";
        }
        if(borrow.getlibrarian_id()<=0){
            error = "please choose librarian";
        }
        if(borrow.getborrow_from_date()==null){
            error = "please choose date borrow";
        }
        if(borrow.getborrow_to_date()==null){
            error = "please choose date return";
        }
        if(borrow.getactual_returned_date()==null){
            error = "please choose date actual returned";
        }
        if(borrow.getlate_fee() < 0){
            error = "late fee must be over or equal to 0";
        }
        if(borrow.getborrow_fee()<= 0){
            error = "borrow fee must be over than 0";
        }
        if(borrow.gettotal()<=0){
            error = "total fee must be over than 0";
        }
        if(error==null){
            System.out.println("1");
            BorrowCRUD.insert(borrow);
            System.out.println("2");
            booktitle.setValue(null);
            member.setValue(null);
            librarian.setValue(null);
            from.setValue(null);
            to.setValue(null);
            actualdate.setValue(null);
            latefee.setText(null);
            borrowfee.setText(null);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Book> bookList = BookCRUD.getList();
        for (Book book : bookList) {
            booktitle.getItems().add(book.gettitle());
        }
        
        List<Member> memberList = MemberCRUD.getList();
        for (Member mem : memberList) {
            member.getItems().add(mem.getemail());
        }
        
        List<Librarian> librarianList = LibrarianCRUD.getList();
        for (Librarian libra : librarianList) {
            librarian.getItems().add(libra.getemail());
        }
    }
}
