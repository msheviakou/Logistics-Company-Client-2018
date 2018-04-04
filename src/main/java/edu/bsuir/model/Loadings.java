package edu.bsuir.model;

import java.sql.Date;
import java.sql.Time;

public class Loadings {
    private int id;
    private String loadingCompanyName;
    private String loadingAdress;
    private String loadingPostalCode;
    private String loadingCity;
    private String loadingCountry;
    private Date loadingDate;
    private Time loadingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoadingCompanyName() {
        return loadingCompanyName;
    }

    public void setLoadingCompanyName(String loadingCompanyName) {
        this.loadingCompanyName = loadingCompanyName;
    }

    public String getLoadingAdress() {
        return loadingAdress;
    }

    public void setLoadingAdress(String loadingAdress) {
        this.loadingAdress = loadingAdress;
    }

    public String getLoadingPostalCode() {
        return loadingPostalCode;
    }

    public void setLoadingPostalCode(String loadingPostalCode) {
        this.loadingPostalCode = loadingPostalCode;
    }

    public String getLoadingCity() {
        return loadingCity;
    }

    public void setLoadingCity(String loadingCity) {
        this.loadingCity = loadingCity;
    }

    public String getLoadingCountry() {
        return loadingCountry;
    }

    public void setLoadingCountry(String loadingCountry) {
        this.loadingCountry = loadingCountry;
    }

    public Date getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(Date loadingDate) {
        this.loadingDate = loadingDate;
    }

    public Time getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(Time loadingTime) {
        this.loadingTime = loadingTime;
    }
}
