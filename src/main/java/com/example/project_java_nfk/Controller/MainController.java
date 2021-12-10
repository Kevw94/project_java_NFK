package com.example.project_java_nfk.Controller;

import com.example.project_java_nfk.Module.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem runlibrary;

    @FXML
    private MenuItem runBinaire;

    @FXML
    private Menu runHexadecimal;

    @FXML
    private MenuItem runIMC;

    @FXML
    private Menu runChiffreRomain;

    @FXML
    private Menu runArmee;

    @FXML
    private AnchorPane pageLibrary;

    @FXML
    private  VBox pageImc;

    @FXML
    private AnchorPane mainAnc;

    @FXML
    private  AnchorPane pageBinaire;

    @FXML
    private AnchorPane pageHexadecimal;

    @FXML
    private AnchorPane pageChiffreRomain;

    @FXML
    private AnchorPane pageArmee;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnAction(event -> {
            System.exit(0);
        });


        mainAnc.getChildren().removeAll(pageLibrary, pageImc, pageBinaire,pageHexadecimal,pageChiffreRomain,pageArmee);


        runlibrary.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageBinaire,pageHexadecimal,pageChiffreRomain,pageArmee);
            mainAnc.getChildren().add(pageLibrary);

        });

        runIMC.setOnMenuValidation(launchBib ->{
            mainAnc.getChildren().removeAll(pageLibrary, pageBinaire,pageHexadecimal,pageChiffreRomain,pageArmee);
            mainAnc.getChildren().add(pageImc);
        });

        runBinaire.setOnMenuValidation(launchBib ->{
            mainAnc.getChildren().removeAll(pageImc, pageLibrary,pageHexadecimal,pageChiffreRomain,pageArmee);
            mainAnc.getChildren().add(pageBinaire);
        });

        runHexadecimal.setOnMenuValidation(launchBib ->{
            mainAnc.getChildren().removeAll(pageImc, pageLibrary,pageBinaire,pageChiffreRomain,pageArmee);
            mainAnc.getChildren().add(pageHexadecimal);
        });

        runChiffreRomain.setOnMenuValidation(launchBib ->{
            mainAnc.getChildren().removeAll(pageImc, pageLibrary,pageHexadecimal,pageArmee);
            mainAnc.getChildren().add(pageChiffreRomain);
        });

        runArmee.setOnMenuValidation(launchBib ->{
            mainAnc.getChildren().removeAll(pageImc, pageLibrary,pageHexadecimal,pageChiffreRomain);
            mainAnc.getChildren().add(pageArmee);
        });


    }

    public ObservableList<Book> getBookPrint(){

                ObservableList<Book> livre = FXCollections.observableArrayList();
                livre.add(new Book("hp","frank",2021,1,3,"ofvner"));
                return livre;


        /*Book bookOne = new Book("nightCall", "Stephen King", 2010, 1, 1, "bonjour");
        bookOne.getBookPrint().add(bookOne);*/


    }
}
