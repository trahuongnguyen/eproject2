package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.crud.BookCRUD;
import com.mycompany.librarymanagement.crud.BorrowCRUD;
import com.mycompany.librarymanagement.model.Author;
import com.mycompany.librarymanagement.model.Book;
import com.mycompany.librarymanagement.model.Borrow;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AuthorlistController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Author, String> authorname;

    @FXML
    private TableView<Author> authortable;

    @FXML
    private TableColumn<Author, String> stt;

    @FXML
    private AnchorPane formvisible;

    @FXML
    private TextField txtauthorname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }

    void initialize() {
        List<Author> dataList = AuthorCRUD.getlist();
        ObservableList<Author> authorlist = FXCollections.observableArrayList(dataList);
        authorname.setCellValueFactory((CellDataFeatures<Author, String> param) -> param.getValue().getProFull_name());
        stt.setCellValueFactory((CellDataFeatures<Author, String> p) -> new ReadOnlyObjectWrapper(authortable.getItems().indexOf(p.getValue()) + 1));
        authortable.setItems(authorlist);
    }
    
    void resetForm(){
        txtauthorname.setText("");
    }

    @FXML
    void displaySelectedItem(MouseEvent event) {
        if (authortable.getSelectionModel().getSelectedItem() != null) {
            author = new Author(AuthorCRUD.getlistByName(authortable.getSelectionModel().getSelectedItem().getfull_name()).get(0).getid(), authortable.getSelectionModel().getSelectedItem().getfull_name());
            formvisible.setVisible(true);
            txtauthorname.setText(authortable.getSelectionModel().getSelectedItem().getfull_name());
        }
    }

    static Author author;

    @FXML
    void updateauthor(MouseEvent event) {
        String auname = !txtauthorname.getText().isEmpty()?txtauthorname.getText():"";
        if (!auname.equalsIgnoreCase("")) {
            Author au = new Author(author.getid(), auname);
            AuthorCRUD.update(au, author.getid());
            resetForm();
            initialize();
        }
    }

    @FXML
    void deleteauthor(MouseEvent event) {
        List<Book> bookList = BookCRUD.getListByAuthorId(author.getid());
        if (bookList.size() > 0) {
            for (Book book : bookList) {
                List<Borrow> borrowList = BorrowCRUD.getListByBookId(book.getid());
                if (borrowList.size() > 0) {
                    for (Borrow borrow : borrowList) {
                        BorrowCRUD.delete(borrow.getid());
                    }
                }
                BookCRUD.deleteBook(book.getid());
            }
        }
        AuthorCRUD.delete(author.getid());
        initialize();
        resetForm();
        formvisible.setVisible(false);
    }
}
