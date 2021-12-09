package com.example.project_java_nfk.Controller;



import com.example.project_java_nfk.Module.Book;
import com.example.project_java_nfk.Module.Library;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class LibraryController implements Initializable {
    boolean duplicate = false;
    public int i = 0;
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

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonRevers;

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

        Library myLibrary = new Library();
        // before validate
        //System.out.println(tbvTtable.getItems() + " items after cells");
        validBook.setOnMouseClicked(actionBTN -> {
            //System.out.println(myLibrary.bookPrint);
            //System.out.println(tbvTtable.getSelectionModel().getSelectedItems());
            // HERE IS PLACE TO PUT METHOD FOR CHECKING VALID BOOK

//            checkDuplicatedBook(myLibrary);


            // IF GOOD --> Create and add book
            newBook(myLibrary);



            //return duplicate;



            // REMOVE TEXT AFTER VALIDATE NEW BOOK
            txtGetTitle.setText(null);
            txtGetAuthorName.setText(null);
            intGetPublished.setText(null);
            intGetColumn.setText(null);
            intGetRange.setText(null);
            txtGetSummary.setText(null);
            //maLybrairie.bookPrint.add(newBook(maLybrairie));


            //System.out.println(tbvTtable.getItems().get(0).getColumn());
            //System.out.println(myLibrary.getBookPrint() + "1");
//            System.out.println(myLibrary.getBookPrint() + "sqd");
//            System.out.println(myLibrary.getBookPrint().get(1) + "ezaeza");
            System.out.println(myLibrary.bookPrint + "\n");
        });
        tbvTtable.setOnMouseClicked(this::handle);
    }

    public boolean checkDuplicatedBook(Library myLibrary){
        for(Book book : myLibrary.getBookPrint()){
            for (int j =0; j< myLibrary.getBookPrint().size(); j++){
                if (myLibrary.getBookPrint().get(j).equals(book)){
                    duplicate = true;
                    System.out.println(duplicate);
                    return true;
                }
                else {
                    duplicate = false;
                    System.out.println(duplicate);
                    return false;
                }

            }


        }
        System.out.println(duplicate);
        return duplicate;
    }

    public Book newBook(Library myLibrary) {

        Book book = new Book(txtGetTitle.getText(), txtGetAuthorName.getText(), (Integer.parseInt(intGetPublished.getText())), (Integer.parseInt(intGetColumn.getText())), (Integer.parseInt(intGetRange.getText())), txtGetSummary.getText());

        if ((book.getColumn() > 0 && book.getColumn() <= 5) && (book.getRange() > 0 && book.getRange() <= 7) && (book.getPublishedDate() <= 2020 && book.getPublishedDate() > 0)) {
            System.out.println("not in");
            myLibrary.getBookPrint().add(book);
            tbvTtable.getItems().add(myLibrary.getBookPrint().get(i));
            i++;
            //TODO FOR NOT DUPLICATE
            if (duplicate == false) {


//                System.out.println("not in");
//                myLibrary.getBookPrint().add(book);
//                tbvTtable.getItems().add(myLibrary.getBookPrint().get(i));
//                i++;

            }
        } else if (duplicate == true) {
            System.out.println("duplicate ");
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
    }
}
