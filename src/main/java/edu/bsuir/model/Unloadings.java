package edu.bsuir.model;

import java.sql.Date;
import java.sql.Time;

public class Unloadings {
    private int id;
    private String unloadingClient;
    private String unloadingCity;
    private String unloadingCountry;
    private Date unloadingDate;
    private Time unloadingTime;

    private Stocks stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnloadingClient() {
        return unloadingClient;
    }

    public void setUnloadingClient(String unloadingClient) {
        this.unloadingClient = unloadingClient;
    }

    public String getUnloadingCity() {
        return unloadingCity;
    }

    public void setUnloadingCity(String unloadingCity) {
        this.unloadingCity = unloadingCity;
    }

    public String getUnloadingCountry() {
        return unloadingCountry;
    }

    public void setUnloadingCountry(String unloadingCountry) {
        this.unloadingCountry = unloadingCountry;
    }

    public Date getUnloadingDate() {
        return unloadingDate;
    }

    public void setUnloadingDate(Date unloadingDate) {
        this.unloadingDate = unloadingDate;
    }

    public Time getUnloadingTime() {
        return unloadingTime;
    }

    public void setUnloadingTime(Time unloadingTime) {
        this.unloadingTime = unloadingTime;
    }

    public Stocks getStock() {
        return stock;
    }

    public void setStock(Stocks stock) {
        this.stock = stock;
    }
}
