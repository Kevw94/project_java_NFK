package com.example.project_java_nfk.Module;

public class Imc {

    private float printSize;
    private float printWeight;
    private float resultOperation;
    private String infoResult;

    public float getPrintSize() {
        return printSize;
    }

    public void setPrintSize(float printSize) {
        this.printSize = printSize;
    }

    public float getPrintWeight() {
        return printWeight;
    }

    public void setPrintWeight(float printWeight) {
        this.printWeight = printWeight;
    }


    public float getResultOperation() {
        return resultOperation;
    }

    public void setResultOperation(float resultOperation) {
        this.resultOperation = resultOperation;
    }

    public String getInfoResult() {
        return infoResult;
    }

    public void setInfoResult(String infoResult) {
        this.infoResult = infoResult;
    }

    public Imc(float printSize, float printWeight, String infoResult) {
        this.printSize = printSize;
        this.printWeight = printWeight;
        this.infoResult = infoResult;

    }
    public void Operation(){
            this.resultOperation = this.printWeight/(this.printSize*this.printSize);}
}

