package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.model.Author;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddauthorController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addauthor_btn;

    @FXML
    private TextField txtauthorname;

    @FXML
    void addauthor_btn(MouseEvent event) {
        String authorname = !txtauthorname.getText().isEmpty() ? txtauthorname.getText() : "";
        Author au = new Author(0, authorname);
        List<Author> authorList = AuthorCRUD.getlist();
        boolean isHave = false;
        if (!authorname.equalsIgnoreCase("")) {
            for (Author author : authorList) {
                if (author.getfull_name().equalsIgnoreCase(au.getfull_name())) {
                    isHave = true;
                    break;
                }
            }
        }

        if (!isHave) {
            AuthorCRUD.insert(au);
            txtauthorname.setText("");
        } else{
            txtauthorname.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
