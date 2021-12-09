package com.example.project_java_nfk;

import com.example.project_java_nfk.Module.Book;
import com.example.project_java_nfk.Module.Library;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("FirstMenuTemplate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
//        Library testLibrary = new Library();
//        testLibrary.newBook();
//        System.out.println(testLibrary.bookPrint);
    }
}