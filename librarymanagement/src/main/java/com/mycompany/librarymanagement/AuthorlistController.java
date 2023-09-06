package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.crud.AuthorCRUD;
import com.mycompany.librarymanagement.model.Author;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class AuthorlistController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Author, String> authorname;

    @FXML
    private TableView authortable;

    @FXML
    private TableColumn<Author, String> stt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Author> dataList = AuthorCRUD.getlist();
        ObservableList<Author> authorlist = FXCollections.observableArrayList(dataList);
        authorname.setCellValueFactory((TableColumn.CellDataFeatures<Author, String> author) -> author.getValue().getProFull_name());
        stt.setCellValueFactory(new Callback<CellDataFeatures<Author, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Author, String> p) {
                return new ReadOnlyObjectWrapper(authortable.getItems().indexOf(p.getValue())+1);
            }
        });
        authortable.setItems(authorlist);
    }

}
