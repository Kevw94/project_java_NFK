package com.example.project_java_nfk.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    @FXML
    private TableColumn<?, ?> printColumn;

    @FXML
    private TableColumn<?, ?> printNamedAuthor;

    @FXML
    private TableColumn<?, ?> printNamedBook;

    @FXML
    private TableColumn<?, ?> printPublishedDate;

    @FXML
    private TableColumn<?, ?> printRange;

    @FXML
    private TableColumn<?, ?> printSummary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
