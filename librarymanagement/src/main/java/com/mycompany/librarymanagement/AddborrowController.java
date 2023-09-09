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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddborrowController implements Initializable {

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
    private ImageView latefeeerror;

    @FXML
    private ImageView borrowfeeerror;

    static Borrow borrow;

    boolean checkerror(TextField txt, ImageView image) {
        if (txt.getText().isEmpty()) {
            image.setVisible(true);
        } else {
            try {
                float fee = Float.parseFloat(txt.getText());
                image.setVisible(false);
            } catch (NumberFormatException e) {
                image.setVisible(true);
            }
        }
        return image.visibleProperty().get();
    }

    boolean validateform() {
        String error = null;
        if (checkerror(latefee, latefeeerror)) {
            error = "not in number format";
        }
        if (checkerror(borrowfee, borrowfeeerror)) {
            error = "not in number format";
        }
        if (borrow.getbook_id() <= 0) {
            error = "please choose book title";
        }
        if (borrow.getcard_member_id() <= 0) {
            error = "please choose card member";
        }
        if (borrow.getlibrarian_id() <= 0) {
            error = "please choose librarian";
        }
        if (borrow.getborrow_from_date() == null) {
            error = "please choose date borrow";
        }
        if (borrow.getborrow_to_date() == null) {
            error = "please choose date return";
        }
        if (borrow.getactual_returned_date() == null) {
            error = "please choose date actual returned";
        }
        if (borrow.getlate_fee() < 0) {
            error = "late fee must be over or equal to 0";
        }
        if (borrow.getborrow_fee() <= 0) {
            error = "borrow fee must be over than 0";
        }
        if (borrow.gettotal() <= 0) {
            error = "total fee must be over than 0";
        }
        return error == null;
    }

    @FXML
    void addborrow(MouseEvent event) {
        LocalDate date = LocalDate.now();

        borrow = new Borrow(
                0,
                booktitle.getValue() != null ? BookCRUD.getListByName(booktitle.getValue()).get(0).getid() : 0,
                member.getValue() != null ? MemberCRUD.getListByEmail(member.getValue()).get(0).getid() : 0,
                librarian.getValue() != null ? LibrarianCRUD.getListByEmail(librarian.getValue()).get(0).getid() : 0,
                from.getValue() != null ? (from.getValue().getYear() + "-" + from.getValue().getMonthValue() + "-" + from.getValue().getDayOfMonth()) : (date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth()),
                to.getValue() != null ? to.getValue().getYear() + "-" + to.getValue().getMonthValue() + "-" + to.getValue().getDayOfMonth() : date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth(),
                actualdate.getValue() != null ?(actualdate.getValue().getYear() + "-" + actualdate.getValue().getMonthValue() + "-" + actualdate.getValue().getDayOfMonth()) : date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth(),
                note.getText() != null ? note.getText() : "",
                !checkerror(latefee, latefeeerror) ? Float.parseFloat(latefee.getText()) : 0,
                !checkerror(borrowfee, borrowfeeerror) ? Float.parseFloat(borrowfee.getText()) : 0,
                !checkerror(latefee, latefeeerror) && !checkerror(borrowfee, borrowfeeerror) ? Float.parseFloat(latefee.getText()) + Float.parseFloat(borrowfee.getText()) : 0
        );

        if (validateform()) {
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
