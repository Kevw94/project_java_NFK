package com.example.project_java_nfk.Controller;



import com.example.project_java_nfk.Module.Book;
import com.example.project_java_nfk.Module.Library;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class LibraryController implements Initializable {
    static Date now = new Date();


    // ------------ COLUMNS OF TABLE VIEW -------------
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

    // ------------ TABLE VIEW ---------------
    @FXML
    private TableView<Book> tbvTtable;

    //------------ INPUT USER -----------

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle ) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
        System.out.println(now);

        printNamedBook.setCellValueFactory(new PropertyValueFactory<>("name"));
        printNamedAuthor.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        printRange.setCellValueFactory(new PropertyValueFactory<>("range"));
        printColumn.setCellValueFactory(new PropertyValueFactory<>("column"));
        printPublishedDate.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));
        printSummary.setCellValueFactory(new PropertyValueFactory<>("summary"));
        validBook.setOnMouseClicked(actionBTN -> {

            Library myLibrary = new Library();
            System.out.println(myLibrary.bookPrint);
            newBook(myLibrary);
            // HERE IS PLACE TO PUT METHOD FOR CHECKING VALID BOOK


            // REMOVE TEXT AFTER VALIDATE NEW BOOK
            txtGetTitle.setText(null);
            txtGetAuthorName.setText(null);
            intGetPublished.setText(null);
            intGetColumn.setText(null);
            intGetRange.setText(null);
            txtGetSummary.setText(null);
            //maLybrairie.bookPrint.add(newBook(maLybrairie));


            System.out.println(tbvTtable.getItems().get(0).getColumn());
            System.out.println(myLibrary.bookPrint);
        });
        tbvTtable.setOnMouseClicked(this::handle);

//        tbvTtable.setOnMouseClicked(actionBTN -> {
//            txtGetTitle.setText(String.valueOf(tbvTtable.getItems(actionBTN).get(0).getName()));
//
//            System.out.println(actionBTN);
//        });


//        Node row = null;
//        assert false;
//        row.setOnMouseClicked(action ->{
//            System.out.println("bonjour");
//        });


    }
    public void checkPlaceCicked(){

    }

    public Book newBook(Library myLibrary){


        Book book = new Book(txtGetTitle.getText(), txtGetAuthorName.getText(),(Integer.parseInt(intGetPublished.getText())),(Integer.parseInt(intGetColumn.getText())),(Integer.parseInt(intGetRange.getText())),txtGetSummary.getText());
        myLibrary.getBookPrint().add(book);
        for (int i = 0; i < tbvTtable.getItems().size(); i++){

            System.out.println(tbvTtable.getItems().get(i) + "hello");

        }


        for (int i = 0; i < myLibrary.getBookPrint().size(); i++) {
            tbvTtable.getItems().add(myLibrary.getBookPrint().get(i));
//
//            // TODO FINISH TO CLOSE USER
//            if (myLibrary.getBookPrint().get(i).getRange() <= i && myLibrary.getBookPrint().get(i).getColumn() <= i) {
//                //TODO POPUP MESSAGE TO TRY AGAIN WITH GOOD VALUES
//                System.out.println("ok");
//
//            }
//            if (myLibrary.getBookPrint().get(i).getPublishedDate() >= now.getTime()) {
//                //TODO RESTRAIN DATE TO USER
//                System.out.println("datttte");
//
//            }
//            if (myLibrary.getBookPrint().get(i).getSummary() instanceof String
//                && myLibrary.getBookPrint().get(i).getAuthorName() instanceof String
//                && myLibrary.getBookPrint().get(i).getName() instanceof String) {
//                // THIS IS FOR ADDING BOOK FROM USER INPUT HERE
//
//
//
//                System.out.println();
//                System.out.println(tbvTtable.getItems().get(i));
//            }
//            else {
//                System.out.println("nope");
//
//
//            }
//            System.out.println(myLibrary.getBookPrint().stream().count());
//            if (myLibrary.getBookPrint().get(i).getRange() == 0){
//                System.out.println("nope");
//            }
        }
        return book;


    }

    private void handle(MouseEvent event) {

        //System.out.println(tbvTtable.getSelectionModel().getSelectedCells() + "cellls");
        //System.out.println(tbvTtable.getSelectionModel().getSelectedItems() + "itemmmms");

        int i = 0;



            txtGetTitle.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getName()));
            txtGetAuthorName.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getAuthorName()));
            intGetPublished.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getPublishedDate()));
            intGetColumn.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getColumn()));
            intGetRange.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getRange()));
            txtGetSummary.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getSummary()));
          //  return;
        //}
        //this.tbvTtable.getSelectionModel().setCellSelectionEnabled(true);
        //this.tbvTtable.setEditable(true);
        Node source = (Node)event.getSource();
        System.out.println(tbvTtable.getOnSort());
        //System.out.println(tbvTtable.getItems().get(getIndex()));
        System.out.println(tbvTtable. getRowFactory());//.getSelectionModel().cellValueFactoryProperty());
        System.out.println(event.getSource());

        //System.out.println(tbvTtable.event.getSource());

       // txtGetTitle.setText(String.valueOf(tbvTtable.getItems().getIndexOf(actionBTN)));
        //getText().getName()
//        actionBTN.getTarget();
//        txtGetTitle.setText(String.valueOf(actionBTN.getTarget()));
//        txtGetTitle.setText(actionBTN.getText());

        //System.out.println(tbvTtable.getItems().get(actionBTN.getTarget()));
        // TODO WIP HERE GET VALUE OF EVENT LISTENER
//        System.out.println(actionBTN.getTarget().getClass().getName());
    }
}
