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
    private float printSize;

    @FXML
    private float printWeight;

    @FXML
    private float resultOperation;

    @FXML
    private float sliderImc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //calculate IMC
        printWeight = Float.parseFloat(String.valueOf(printWeight));
        printSize = Float.parseFloat(String.valueOf(printSize));
        resultOperation = Float.parseFloat(String.valueOf(resultOperation));
        float poids = 60;
        float taille = (float) 1.60;
        float result = (printWeight/(taille*taille));
        // round on decimal
        DecimalFormat result1 = new DecimalFormat("##.#");
        String outpout = result1.format(result);
        sliderImc = resultOperation;
        System.out.println(outpout);
        // condition for print info IMC
        if (outpout.length() < 16.5) {
            System.out.println("Famine");
        } else if (outpout.length() > 16.5 && outpout.length() < 18.5){
            System.out.println("Maigreur");
        } else if (outpout.length() > 18.5 && outpout.length() < 25){
            System.out.println("Corpulence normale");
        } else if (outpout.length() > 25 && outpout.length() < 30){
            System.out.println("Surpoids");
        } else if (outpout.length() > 30 && outpout.length() < 35){
            System.out.println("Obésité modérée");
        } else if (outpout.length() > 35 && outpout.length() < 40){
            System.out.println("Obésité sévére");
        } else {
            System.out.println("Obésité morbide ou masive");
        };


    }
}
