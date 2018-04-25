package edu.bsuir.form;

import edu.bsuir.model.Notices;

import java.sql.Date;

public class OrdersForm {
    private int id;
    private Date dateOfOrder;
    private String numberOfOrder;
    private String orderStatus;
    private Double freightCost;
    private String paymentPeriod;
    private String additionalInformation;

    private CarriersForm carrier;
    private CargosForm cargo;
    private LoadingsForm loading;
    private UnloadingsForm unloading;
    private Notices notice;
    private UsersForm userForwarderBY;
    private UsersForm userForwarderPL;

    public OrdersForm() {}

    public OrdersForm(Date dateOfOrder, String numberOfOrder, String orderStatus,
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

    public CarriersForm getCarrier() {
        return carrier;
    }

    public void setCarrier(CarriersForm carrier) {
        this.carrier = carrier;
    }

    public CargosForm getCargo() {
        return cargo;
    }

    public void setCargo(CargosForm cargo) {
        this.cargo = cargo;
    }

    public LoadingsForm getLoading() {
        return loading;
    }

    public void setLoading(LoadingsForm loading) {
        this.loading = loading;
    }

    public UnloadingsForm getUnloading() {
        return unloading;
    }

    public void setUnloading(UnloadingsForm unloading) {
        this.unloading = unloading;
    }

    public Notices getNotice() {
        return notice;
    }

    public void setNotice (Notices notice) {
        this.notice = notice;
    }

    public UsersForm getUserForwarderBY() {
        return userForwarderBY;
    }

    public void setUserForwarderBY (UsersForm userForwarderBY) {
        this.userForwarderBY = userForwarderBY;
    }

    public UsersForm getUserForwarderPL() {
        return userForwarderPL;
    }

    public void setUserForwarderPL (UsersForm userForwarderPL) {
        this.userForwarderPL = userForwarderPL;
    }
}
