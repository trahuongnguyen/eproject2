package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.model.Borrow;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddborrowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker actualdate;

    @FXML
    private Button addborrow_btn;

    @FXML
    private ComboBox<?> booktitle;

    @FXML
    private TextField borrowfee;

    @FXML
    private DatePicker from;

    @FXML
    private TextField latefee;

    @FXML
    private ComboBox<?> librarian;

    @FXML
    private ComboBox<?> member;

    @FXML
    private TextArea note;

    @FXML
    private DatePicker to;

    @FXML
    void addborrow(MouseEvent event) {
        LocalDate localDate = from.getValue();
        @Deprecated
        Date date = new Date(from.getValue().getYear(), from.getValue().getMonthValue(), from.getValue().getDayOfMonth());
        Borrow borrow = new Borrow(
                0,
                booktitle.getVisibleRowCount(),
                member.getVisibleRowCount(),
                librarian.getVisibleRowCount(),
                new Date(from.getValue().getYear(), from.getValue().getMonthValue(), from.getValue().getDayOfMonth()),
                new Date(from.getValue().getYear(), from.getValue().getMonthValue(), from.getValue().getDayOfMonth()),
                new Date(from.getValue().getYear(), from.getValue().getMonthValue(), from.getValue().getDayOfMonth()),
                note.getText(),
                Float.parseFloat(latefee.getText()),
                Float.parseFloat(borrowfee.getText()),
                Float.parseFloat(latefee.getText()) + Integer.parseInt(borrowfee.getText())
        );
    }

    @FXML
    void initialize() {
    }

}
