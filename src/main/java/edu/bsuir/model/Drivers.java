package edu.bsuir.model;

public class Drivers {
    private int id;
    private String phoneNumber;
    private String name;
    private String trukRegNumber;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrukRegNumber() {
        return trukRegNumber;
    }

    public void setTrukRegNumber(String trukRegNumber) {
        this.trukRegNumber = trukRegNumber;
    }
}
