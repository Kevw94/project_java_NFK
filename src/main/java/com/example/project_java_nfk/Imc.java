package com.example.project_java_nfk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Imc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Imc.class.getResource("imc.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Votre IMC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }


}
