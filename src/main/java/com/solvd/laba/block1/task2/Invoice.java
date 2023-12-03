package com.solvd.laba.block1.task2;


public class Invoice {
    private String serviceInfo;
    private String currency;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public void setInvoice(double cost, String address, String currency) {
        this.amount = cost;
        this.currency = currency;
        this.serviceInfo = address;
    }

    public String getBill() {
        return "Your invoice = " + this.amount +
                " " + this.currency;

    }
}
