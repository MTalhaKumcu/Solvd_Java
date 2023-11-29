package com.solvd.laba.block1.task2.block1.task2;

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
