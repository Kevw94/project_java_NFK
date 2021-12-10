package com.example.project_java_nfk.Controller;



import com.example.project_java_nfk.Module.Book;
import com.example.project_java_nfk.Module.Library;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class LibraryController implements Initializable {
    boolean boolModified = false;
    boolean boolAddBook = true;
    public int i = 0;
    static Date now = new Date();


    @FXML
    private DialogPane dlgError;

    @FXML
    private ImageView imgUrl;


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
    private TextField intGetColumn;

    @FXML
    private TextField intGetPublished;

    @FXML
    private TextField txtGetUrl;

    @FXML
    private TextField intGetRange;

    @FXML
    private TextField txtGetAuthorName;

    @FXML
    private TextArea txtGetSummary;

    @FXML
    private TextField txtGetTitle;

    //------------ BTN ACTION ----------

    @FXML
    private Button validBook;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonRevers;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle ) {
        //dlgError.setDisable(true);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
        System.out.println(now);
        //DialogPane dialog = new DialogPane();

        // FOR DISABLE OR NOT FORMULARY INPUT
        txtGetUrl.setDisable(true);
        txtGetTitle.setDisable(boolAddBook);
        txtGetSummary.setDisable(boolAddBook);
        txtGetAuthorName.setDisable(boolAddBook);
        intGetRange.setDisable(boolAddBook);
        intGetPublished.setDisable(boolAddBook);
        intGetColumn.setDisable(boolAddBook);
        validBook.setDisable(boolAddBook);


        // SETTING CELLS TO TABLE VIEW FOR GETTING DATA FROM USER INPUT
        printNamedBook.setCellValueFactory(new PropertyValueFactory<>("name"));
        printNamedAuthor.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        printRange.setCellValueFactory(new PropertyValueFactory<>("range"));
        printColumn.setCellValueFactory(new PropertyValueFactory<>("column"));
        printPublishedDate.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));
        printSummary.setCellValueFactory(new PropertyValueFactory<>("summary"));

        Library myLibrary = new Library();



        //  -------- EVENT LISTENER ON DISPLAY APPLICATION ---------

        buttonAdd.setOnMouseClicked(this::forEnableFormularyToAddBook);

        buttonRevers.setOnMouseClicked(event -> forRemoveBookInTableView(myLibrary));

        // before validate
        validBook.setOnMouseClicked(event -> createBookOnBtnValidate(myLibrary));

        tbvTtable.setOnMouseClicked(this::showSelectedBookInForm);
        if (i == -1){
            i = 0;
            System.out.println(i);
        }
    }




    // --------------- END OF EVENT LISTENER ---------------------------








    // Create New Book and add it in the TableView
    public Book newBook(Library myLibrary) {
        Book book = new Book(txtGetTitle.getText(),
                txtGetAuthorName.getText(),
                (Integer.parseInt(intGetPublished.getText())),
                txtGetUrl.getText(),
                (Integer.parseInt(intGetColumn.getText())),
                (Integer.parseInt(intGetRange.getText())),
                txtGetSummary.getText());


        if ((book.getColumn() > 0 && book.getColumn() <= 5) &&
                (book.getRange() > 0 && book.getRange() <= 7) &&
                (book.getPublishedDate() <= 2020 && book.getPublishedDate() > 0) && boolModified == false ) {
            myLibrary.getBookPrint().add(book);
            tbvTtable.getItems().add(myLibrary.getBookPrint().get(i));
            i++;
        }
        else if (boolModified == true){

            int index = tbvTtable.getSelectionModel().getSelectedIndex();
            myLibrary.getBookPrint().get(index).setAuthorName(txtGetAuthorName.getText());
            myLibrary.getBookPrint().get(index).setName(txtGetTitle.getText());
            myLibrary.getBookPrint().get(index).setPublishedDate((Integer.parseInt(intGetPublished.getText())));
            myLibrary.getBookPrint().get(index).setColumn((Integer.parseInt(intGetColumn.getText())));
            myLibrary.getBookPrint().get(index).setRange((Integer.parseInt(intGetRange.getText())));
            myLibrary.getBookPrint().get(index).setSummary(txtGetSummary.getText());

            tbvTtable.refresh();
        }

        boolAddBook = true;
        // FOR DISABLE OR NOT FORMULARY INPUT
        txtGetTitle.setDisable(boolAddBook);
        txtGetSummary.setDisable(boolAddBook);
        txtGetAuthorName.setDisable(boolAddBook);
        intGetRange.setDisable(boolAddBook);
        intGetPublished.setDisable(boolAddBook);
        intGetColumn.setDisable(boolAddBook);
        validBook.setDisable(boolAddBook);
        return book;
    }

    // ----------- METHOD OF EVENT LISTENER ----------------------

    private void showSelectedBookInForm(MouseEvent event) {
        //System.out.println(tbvTtable.getSelectionModel().getSelectedCells() + "cellls");
        //System.out.println(tbvTtable.getSelectionModel().getSelectedItems() + "itemmmms");
        int i = 0;
        boolModified = true;
        boolAddBook = false;

        txtGetTitle.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getName()));
        txtGetAuthorName.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getAuthorName()));
        intGetPublished.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getPublishedDate()));
        intGetColumn.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getColumn()));
        intGetRange.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getRange()));
        txtGetSummary.setText(String.valueOf(tbvTtable.getSelectionModel().getSelectedItems().get(i).getSummary()));


        // FOR DISABLE OR NOT FORMULARY INPUT
        txtGetTitle.setDisable(boolAddBook);
        txtGetSummary.setDisable(boolAddBook);
        txtGetAuthorName.setDisable(boolAddBook);
        intGetRange.setDisable(boolAddBook);
        intGetPublished.setDisable(boolAddBook);
        intGetColumn.setDisable(boolAddBook);
        validBook.setDisable(boolAddBook);


    }

    private void createBookOnBtnValidate(Library myLibrary){
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
           // System.out.println(myLibrary.bookPrint + "\n");
    };


    private void forEnableFormularyToAddBook(MouseEvent event) {
        boolModified = false;
        // FOR DISABLE OR NOT FORMULARY INPUT
        boolAddBook = false;
        txtGetTitle.setDisable(boolAddBook);
        txtGetSummary.setDisable(boolAddBook);
        txtGetAuthorName.setDisable(boolAddBook);
        intGetRange.setDisable(boolAddBook);
        intGetPublished.setDisable(boolAddBook);
        intGetColumn.setDisable(boolAddBook);
        validBook.setDisable(boolAddBook);
        System.out.println(boolAddBook);
    }

    private void forRemoveBookInTableView(Library myLibrary) {
        i--;

        ObservableList selectedCells = tbvTtable.getSelectionModel().getSelectedCells();
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        int row = tablePosition.getRow();
        //System.out.println(row);
        myLibrary.getBookPrint().remove(row);
        tbvTtable.getItems().remove(row);
        // doubt here

        // FOR ClEAN FORMULARY INPUT
        tbvTtable.refresh();
        txtGetTitle.setText(null);
        txtGetAuthorName.setText(null);
        intGetPublished.setText(null);
        intGetColumn.setText(null);
        intGetRange.setText(null);
        txtGetSummary.setText(null);


        boolAddBook = true;
        // FOR DISABLE OR NOT FORMULARY INPUT
        txtGetTitle.setDisable(boolAddBook);
        txtGetSummary.setDisable(boolAddBook);
        txtGetAuthorName.setDisable(boolAddBook);
        intGetRange.setDisable(boolAddBook);
        intGetPublished.setDisable(boolAddBook);
        intGetColumn.setDisable(boolAddBook);
        validBook.setDisable(boolAddBook);

    }









// -------------------------- TEST -------------------------------

//
//    public boolean checkDuplicatedBook(Library myLibrary){
//        for(Book book : myLibrary.getBookPrint()){
//            for (int j =0; j< myLibrary.getBookPrint().size(); j++){
//                if (myLibrary.getBookPrint().get(j).equals(book)){
//                    boolAddBook = false;
//                    System.out.println(boolAddBook);
//                    return true;
//                }
//                else {
//                    boolAddBook = true;
//                    System.out.println(boolAddBook);
//                    return true;
//                }
//
//            }
//
//
//        }
//        System.out.println(boolAddBook);
//        return boolAddBook;
//    }
}


