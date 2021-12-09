package com.example.project_java_nfk.Module;

import java.text.DecimalFormat;

public class Imc {
    public Imc() {
        //calculate IMC
        float poids = 60;
        float taille = (float) 1.60;
        float result = (poids / (taille * taille));
        // round on decimal
        DecimalFormat result1 = new DecimalFormat("##.#");
        String outpout = result1.format(result);
        System.out.println(outpout);
        // condition for print info IMC
        if (outpout.length() < 16.5) {
            System.out.println("Famine");
        } else if (outpout.length() > 16.5 && outpout.length() < 18.5) {
            System.out.println("Maigreur");
        } else if (outpout.length() > 18.5 && outpout.length() < 25) {
            System.out.println("Corpulence normale");
        } else if (outpout.length() > 25 && outpout.length() < 30) {
            System.out.println("Surpoids");
        } else if (outpout.length() > 30 && outpout.length() < 35) {
            System.out.println("Obésité modérée");
        } else if (outpout.length() > 35 && outpout.length() < 40) {
            System.out.println("Obésité sévére");
        } else {
            System.out.println("Obésité morbide ou masive");
        }
    }
}

