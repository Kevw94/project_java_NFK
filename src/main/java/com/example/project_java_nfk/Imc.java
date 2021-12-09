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
        //calculate IMC
        /**float poids = 60;
        float taille = (float) 1.60;
        float result = (poids/(taille*taille));
        // round on decimal
        DecimalFormat result1 = new DecimalFormat("##.#");
        String outpout = result1.format(result);

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
        };**/

        

//        Scanner scanner = new Scanner(System.in);
//        class Imc1 {
//            int poids;
//            int taille;
//            int power = 2;
//            float resultTest = (int) Double.parseDouble((poids/taille)*Math.pow(taille));
//            float result = (float) Double.parseDouble(poids + "/" + taille + "^"+ power);
//            float resultPower = (float) CalculatePower(taille, power);
//
//            private double CalculatePower(float taille, float power) {
//                return Math.pow(taille, power);
//            }
//        }
//
//        Imc1 imc = new Imc1();
//        imc.taille = scanner.nextInt();
//        imc.poids = scanner.nextInt();
//        //imc.result = Float.parseFloat((imc.poids + "/" + imc.resultPower));
//        System.out.println(imc.resultTest);
//        //System.out.println(imc.poids + "/" + "(" + imc.taille+ "^"+ imc.power +")"+ "="+ imc.result);




    }


}
