package edu.bsuir.form;

import edu.bsuir.model.Drivers;

public class CarriersForm {
    private int id;
    private String carrierCompanyName;
    private String carrierContact;
    private String carrierTelephone;
    private String carrierElMail;

    private Drivers driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrierCompanyName() {
        return carrierCompanyName;
    }

    public void setCarrierCompanyName(String carrierCompanyName) {
        this.carrierCompanyName = carrierCompanyName;
    }

    public String getCarrierContact() {
        return carrierContact;
    }

    public void setCarrierContact(String carrierContact) {
        this.carrierContact = carrierContact;
    }

    public String getCarrierTelephone() {
        return carrierTelephone;
    }

    public void setCarrierTelephone(String carrierTelephone) {
        this.carrierTelephone = carrierTelephone;
    }

    public String getCarrierElMail() {
        return carrierElMail;
    }

    public void setCarrierElMail(String carrierElMail) {
        this.carrierElMail = carrierElMail;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
}
