package edu.bsuir.form;

import java.sql.Date;

public class LoadingsForm {
    private int id;
    private String loadingCompanyName;
    private String loadingAdress;
    private String loadingPostalCode;
    private String loadingCity;
    private String loadingCountry;
    private Date loadingDate;
    private String loadingTime;

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

    public String getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(String loadingTime) {
        this.loadingTime = loadingTime;
    }
}
