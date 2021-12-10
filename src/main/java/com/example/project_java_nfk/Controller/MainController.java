package com.example.project_java_nfk.Controller;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import com.example.project_java_nfk.Module.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private AnchorPane pageImc;

    @FXML
    private AnchorPane mainAnc;

    @FXML
    private AnchorPane pageBinaire;

    @FXML
    private AnchorPane pageHexadecimal;

    @FXML
    private AnchorPane pageChiffreRomain;

    @FXML
    private AnchorPane pageArmee;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainAnc.getChildren().removeAll(pageLibrary, pageImc, pageBinaire, pageHexadecimal, pageChiffreRomain, pageArmee);


        runlibrary.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageBinaire, pageHexadecimal, pageChiffreRomain, pageArmee);
            mainAnc.getChildren().add(pageLibrary);

        });

        runIMC.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageLibrary, pageBinaire, pageHexadecimal, pageChiffreRomain, pageArmee);
            mainAnc.getChildren().add(pageImc);
        });

        runBinaire.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageLibrary, pageHexadecimal, pageChiffreRomain, pageArmee);
            mainAnc.getChildren().add(pageBinaire);
        });

        runHexadecimal.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageLibrary, pageBinaire, pageChiffreRomain, pageArmee);
            mainAnc.getChildren().add(pageHexadecimal);
        });

        runChiffreRomain.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageLibrary, pageHexadecimal, pageArmee);
            mainAnc.getChildren().add(pageChiffreRomain);
        });

        runArmee.setOnMenuValidation(launchBib -> {
            mainAnc.getChildren().removeAll(pageImc, pageLibrary, pageHexadecimal, pageChiffreRomain);
            mainAnc.getChildren().add(pageArmee);
        });


        //}


    }

        public class ImageInputEffectExample extends Application {
            @Override
            public void start(Stage stage) {
                //Creating an image
                Image image = new Image("http://www.tutorialspoint.com/green/images/logo.png");

                //Instantiating the Rectangle class
                Rectangle rectangle = new Rectangle();

                //Instantiating the ImageInput class
                ImageInput imageInput = new ImageInput();

                //Setting the position of the image
                imageInput.setX(150);
                imageInput.setY(100);

                //Setting source for image input
                imageInput.setSource(image);

                //Applying image input effect to the rectangle node
                rectangle.setEffect(imageInput);

                //Creating a Group object
                Group root = new Group(rectangle);

                //Creating a scene object
                Scene scene = new Scene(root, 600, 300);

                //Setting title to the Stage
                stage.setTitle("Sample Application");

                //Adding scene to the stage
                stage.setScene(scene);

                //Displaying the contents of the stage
                stage.show();
            }

        }


//    public ObservableList<Book> getBookPrint(){
//
//                //ObservableList<Book> livre = FXCollections.observableArrayList();
//                //livre.add(new Book("hp","frank",2021,1,3,"ofvner"));
//               // return livre;
//
//
//        /*Book bookOne = new Book("nightCall", "Stephen King", 2010, 1, 1, "bonjour");
//        bookOne.getBookPrint().add(bookOne);*/
//
//
//    }
    }

