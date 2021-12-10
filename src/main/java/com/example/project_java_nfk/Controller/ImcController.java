package com.example.project_java_nfk.Controller;

import com.example.project_java_nfk.Module.Imc;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ImcController implements Initializable {
    @FXML
    private TextField infoResult;

    @FXML
    private Button operation;

    @FXML
    private TextField printSize;

    @FXML
    private TextField printWeight;


    @FXML
    private TextField resultOperation;

    @FXML
    private Slider sliderImc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        operation.setOnMouseClicked(btnaction -> {
            Imc monImc= new Imc (Float.parseFloat(printSize.getText()), Float.parseFloat(printWeight.getText())
                     ,infoResult.getText());

            monImc.Operation();
            resultOperation.setText(String.valueOf(monImc.getResultOperation()));
            monImc.Operation();
            System.out.println(monImc.getResultOperation());


            if (monImc.getResultOperation() < 16.5) {
                infoResult.setText("Famine");
            } else if (monImc.getResultOperation() > 16.5 && monImc.getResultOperation() < 18.5) {
                infoResult.setText("Maigreur");
            } else if (monImc.getResultOperation() > 18.5 && monImc.getResultOperation() < 25) {
                infoResult.setText("Corpulence normale");
            } else if (monImc.getResultOperation() > 25 && monImc.getResultOperation() < 30) {
                infoResult.setText("Surpoids");
            } else if (monImc.getResultOperation() > 30 && monImc.getResultOperation() < 35) {
                infoResult.setText("Obésité modérée");
            } else if (monImc.getResultOperation() > 35 && monImc.getResultOperation() < 40) {
                infoResult.setText("Obésité sévére");
            } else {
                infoResult.setText("Obésité morbide ou massive");
            }
        });
    }
}
