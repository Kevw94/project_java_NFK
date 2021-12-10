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
    //Unirest
    private Stage stage;
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
        validBook.setOnMouseClicked(event -> createBookOnBtnValidate(myLibrary, stage));

        tbvTtable.setOnMouseClicked(this::showSelectedBookInForm);
    }




    // --------------- END OF EVENT LISTENER ---------------------------








    // Create New Book and add it in the TableView
    public Book newBook(Library myLibrary, Stage stage) {
        //"https://dog.ceo/api/breeds/image/random"



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

            try {

                InputStream stream = new FileInputStream(txtGetUrl.getText());
                //Image image = new Image();
                //ImageView imageView = new ImageView();
                imgUrl.setImage(new Image("https:/toppng.com/uploads/preview/site-de-telechargement-de-photos-et-images-gratuites-point-d-interrogation-libre-de-droit-11563164956sl8mkeund8.png"));
                //Setting image to the image view
//                imageView.setImage(image);
//                //Setting the image view parameters
//                imageView.setX(10);
//                imageView.setY(10);
//                imageView.setFitWidth(575);
//                imageView.setPreserveRatio(true);
//                //Setting the Scene object
//                Group root = new Group(imageView);
//                Scene scene = new Scene(root, 595, 370);
//                stage.setTitle("Displaying Image");
//                stage.setScene(scene);
//                stage.show();
//
//                System.out.println(stream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //System.out.println("not in");
            myLibrary.getBookPrint().add(book);
            tbvTtable.getItems().add(myLibrary.getBookPrint().get(i));
//            InputStream stream = null;



//            Class<?> clazz = this.getClass();
//            InputStream input = clazz.getResourceAsStream(txtGetUrl.getText());
//            Image image = new Image(input);
//            ImageView imageView = new ImageView(image);
//            imageView.setDisable(false);


            //imgUrl.setSource(txtGetUrl.getText());
            //image.setImage(imgUrl.getText());

            i++;
        }
        else if (boolModified == true){

            //TODO REPLACE DATA SELECTED IN TABLEVIEW
            System.out.println("test");
            System.out.println("bonjour");
//            myLibrary.getBookPrint().replace( tbvTtable.getSelectionModel().getSelectedItems());
//            tbvTtable.getItems().replace(myLibrary.getBookPrint().get(i));
//
//            ObservableList selectedCells = tbvTtable.getSelectionModel().getSelectedCells();
//            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
//            int row = tablePosition.getRow();
//            myLibrary.getBookPrint().replaceAll();

            //tbvTtable.getItems().add(myLibrary.getBookPrint().get(row));
            //System.out.println(row);
            //myLibrary.getBookPrint().remove(row);
            //tbvTtable.getItems().remove(row);
            //myLibrary.getBookPrint().replaceAll();




        }
        else {

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

    private void createBookOnBtnValidate(Library myLibrary, Stage stage){
            // HERE IS PLACE TO PUT METHOD FOR CHECKING VALID BOOK
//            checkDuplicatedBook(myLibrary);
            // IF GOOD --> Create and add book
            newBook(myLibrary, stage);

            //return duplicate;
            // REMOVE TEXT AFTER VALIDATE NEW BOOK
            txtGetTitle.setText(null);
            txtGetAuthorName.setText(null);
            intGetPublished.setText(null);
            intGetColumn.setText(null);
            intGetRange.setText(null);
            txtGetSummary.setText(null);
            //maLybrairie.bookPrint.add(newBook(maLybrairie));
            System.out.println(myLibrary.bookPrint + "\n");
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
        // TODO IF TIME PREVENT REMOVING WITHOUT STRICTLY SELECTED TIME
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


