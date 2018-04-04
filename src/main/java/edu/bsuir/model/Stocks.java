package edu.bsuir.model;

public class Stocks {
    private int id;
    private String stockName;
    private String stockAdress;
    private String stockPostalCode;
    private String stockCity;
    private String stockCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockAdress() {
        return stockAdress;
    }

    public void setStockAdress(String stockAdress) {
        this.stockAdress = stockAdress;
    }

    public String getStockPostalCode() {
        return stockPostalCode;
    }

    public void setStockPostalCode(String stockPostalCode) {
        this.stockPostalCode = stockPostalCode;
    }

    public String getStockCity() {
        return stockCity;
    }

    public void setStockCity(String stockCity) {
        this.stockCity = stockCity;
    }

    public String getStockCountry() {
        return stockCountry;
    }

    public void setStockCountry(String stockCountry) {
        this.stockCountry = stockCountry;
    }
}
