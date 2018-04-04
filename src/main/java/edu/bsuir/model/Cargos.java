package edu.bsuir.model;

public class Cargos {
    private int id;
    private String cargoDescription;
    private int cargoWeight;
    private int cargoCount;
    private String cargoDocument;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCargoCount() {
        return cargoCount;
    }

    public void setCargoCount(int cargoCount) {
        this.cargoCount = cargoCount;
    }

    public String getCargoDocument() {
        return cargoDocument;
    }

    public void setCargoDocument(String cargoDocument) {
        this.cargoDocument = cargoDocument;
    }
}
