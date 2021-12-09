package com.example.project_java_nfk.Controller;

import com.example.project_java_nfk.Module.Book;
import com.example.project_java_nfk.Module.Library;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    @FXML
    private TableColumn<Book, Integer> printColumn;

    @FXML
    private TableColumn<Book, String> printNamedAuthor;

    @FXML
    private TableColumn<Book, String> printNamedBook;

    @FXML
    private TableColumn<Book, Integer> printPublishedDate;

    @FXML
    private TableColumn<Book, Integer> printRange;

    @FXML
    private TableColumn<Book, String> printSummary;

    @FXML
    private TableView<Book> tbvTtable;

    @FXML
    private Button validBook;

    @FXML
    private TextField intGetColumn;

    @FXML
    private TextField intGetPublished;

    @FXML
    private TextField intGetRange;

    @FXML
    private TextField txtGetAuthorName;

    @FXML
    private TextArea txtGetSummary;

    @FXML
    private TextField txtGetTitle;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonRevers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle ) {
        Library maLybrairie = new Library();
        printNamedBook.setCellValueFactory(new PropertyValueFactory<>("name"));
        printNamedAuthor.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        printRange.setCellValueFactory(new PropertyValueFactory<>("range"));
        printColumn.setCellValueFactory(new PropertyValueFactory<>("column"));
        printPublishedDate.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));
        printSummary.setCellValueFactory(new PropertyValueFactory<>("summary"));
        validBook.setOnMouseClicked(actionBTN -> {
            newBook(maLybrairie);
        });


    }

    public void newBook(Library maLybrairie){
        Book bookTwo = new Book(txtGetTitle.getText(), txtGetAuthorName.getText(),(Integer.parseInt(intGetPublished.getText())),(Integer.parseInt(intGetColumn.getText())),(Integer.parseInt(intGetRange.getText())),txtGetSummary.getText());
        maLybrairie.getBookPrint().add(bookTwo);
        for (int i = 0; i < maLybrairie.getBookPrint().size(); i++) {
            tbvTtable.getItems().add(maLybrairie.getBookPrint().get(i));
        }
    }



}
