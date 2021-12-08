package com.example.project_java_nfk.Controller;

import com.example.project_java_nfk.Module.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;



/*public class MainController  {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}*/
public class MainController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {






    }

    public ObservableList<Book> getBookPrint(){

                ObservableList<Book> livre = FXCollections.observableArrayList();
                livre.add(new Book("hp","frank",2021,1,3,"ofvner"));
                return livre;


        /*Book bookOne = new Book("nightCall", "Stephen King", 2010, 1, 1, "bonjour");
        bookOne.getBookPrint().add(bookOne);*/


    }
}
