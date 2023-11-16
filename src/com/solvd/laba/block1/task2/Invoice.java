package com.solvd.laba.block1.task2;

public class Invoice {
    private Double amount;
    private String currency;
    private String address;
    public static Invoice invoice;

    public Invoice() {
    }

    public Invoice(Double amount, String currency, String address) {
        this.amount = amount;
        this.currency = currency;
        this.address = address;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static Invoice getInvoice() {
        return invoice;
    }

    public static void setInvoice(double cost, String currency, String address) {
        if (invoice == null) {
            invoice = new Invoice();
        }

        invoice.amount = cost;
        invoice.currency = currency;
        invoice.address = address;
    }

    public static String getBill() {
        return "Your Invoice= " + invoice.amount
                                + invoice.currency
                                + invoice.address;
    }

}
