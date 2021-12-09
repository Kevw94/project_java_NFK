package com.example.project_java_nfk.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
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


    public TextField getInfoResult() {
        return infoResult;
    }

    public void setInfoResult(TextField infoResult) {
        this.infoResult = infoResult;
    }

    public Button getOperation() {
        return operation;
    }

    public void setOperation(Button operation) {
        this.operation = operation;
    }

    public TextField getPrintSize() {
        return printSize;
    }

    public void setPrintSize(TextField printSize) {
        this.printSize = printSize;
    }

    public TextField getPrintWeight() {
        return printWeight;
    }

    public void setPrintWeight(TextField printWeight) {
        this.printWeight = printWeight;
    }

    public TextField getResultOperation() {
        return resultOperation;
    }

    public void setResultOperation(TextField resultOperation) {
        this.resultOperation = resultOperation;
    }

    public Slider getSliderImc() {
        return sliderImc;
    }

    public void setSliderImc(Slider sliderImc) {
        this.sliderImc = sliderImc;
    }

    public ImcController(TextField infoResult, Button operation, TextField printSize, TextField printWeight, TextField resultOperation, Slider sliderImc) {
        this.infoResult = infoResult;
        this.operation = operation;
        this.printSize = printSize;
        this.printWeight = printWeight;
        this.resultOperation = resultOperation;
        this.sliderImc = sliderImc;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printSize.setText("size");
        printWeight.setText("weight");
        resultOperation.setText("result");
        sliderImc.setShowTickLabels(true);
        infoResult.setText("info");

        operation.setOnMouseClicked(btnaction -> {
            operation.setText("Calculé");
            if (resultOperation.getText().length() < 16.5) {
                infoResult.setText("Famine");
            } else if (resultOperation.getText().length() < 16.5 && resultOperation.getText().length() > 18.5) {
                infoResult.setText("Maigreur");
            } else if (resultOperation.getText().length() < 18.5 && resultOperation.getText().length() > 25) {
                infoResult.setText("Corpulence normale");
            } else if (resultOperation.getText().length() < 25 && resultOperation.getText().length() > 30) {
                infoResult.setText("Surpoids");
            } else if (resultOperation.getText().length() < 30 && resultOperation.getText().length() > 35) {
                infoResult.setText("Obésité modérée");
            } else if (resultOperation.getText().length() < 35 && resultOperation.getText().length() > 40) {
                infoResult.setText("Obésité sévére");
            } else {
                infoResult.setText("Obésité morbide ou massive");
            }
        });
    }


}
