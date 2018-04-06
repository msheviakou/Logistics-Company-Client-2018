package edu.bsuir.model;

import java.sql.Date;

public class Orders {
    private int id;
    private Date dateOfOrder;
    private String numberOfOrder;
    private String orderStatus;
    private Double freightCost;
    private String paymentPeriod;
    private String additionalInformation;

    private Carriers carrier;
    private Cargos cargo;
    private Loadings loading;
    private Unloadings unloading;
    private Notices notice;
    private Users userForwarderBY;
    private Users userForwarderPL;

    public Orders() {}

    public Orders(Date dateOfOrder, String numberOfOrder, String orderStatus,
                  Double freightCost, String paymentPeriod, String additionalInformation) {
        this.dateOfOrder = dateOfOrder;
        this.numberOfOrder = numberOfOrder;
        this.orderStatus = orderStatus;
        this.freightCost = freightCost;
        this.paymentPeriod = paymentPeriod;
        this.additionalInformation = additionalInformation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(String numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(Double freightCost) {
        this.freightCost = freightCost;
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) { this.additionalInformation = additionalInformation; }

    public Carriers getCarrier() {
        return carrier;
    }

    public void setCarrier(Carriers carrier) {
        this.carrier = carrier;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public Loadings getLoading() {
        return loading;
    }

    public void setLoading(Loadings loading) {
        this.loading = loading;
    }

    public Unloadings getUnloading() {
        return unloading;
    }

    public void setUnloading(Unloadings unloading) {
        this.unloading = unloading;
    }

    public Notices getNotice() {
        return notice;
    }

    public void setNotice (Notices notice) {
        this.notice = notice;
    }

    public Users getUserForwarderBY() {
        return userForwarderBY;
    }

    public void setUserForwarderBY (Users userForwarderBY) {
        this.userForwarderBY = userForwarderBY;
    }

    public Users getUserForwarderPL() {
        return userForwarderPL;
    }

    public void setUserForwarderPL (Users userForwarderPL) {
        this.userForwarderPL = userForwarderPL;
    }
}
