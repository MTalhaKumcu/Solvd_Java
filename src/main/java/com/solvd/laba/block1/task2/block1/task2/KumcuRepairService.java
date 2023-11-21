package com.solvd.laba.block1.task2.block1.task2;

import java.util.Scanner;

public abstract class KumcuRepairService {
    private Customer customer;
    private DiagnosticReport report;
    private PaymentDepartment payment;
    protected Scanner scan;

    public KumcuRepairService() {

        this.scan = new Scanner(System.in);

    }

    public KumcuRepairService(Customer customer) {
        this.scan = new Scanner(System.in);
        this.customer = customer;
    }

    public KumcuRepairService(Customer customer, DiagnosticReport report, PaymentDepartment payment) {
        this.scan = new Scanner(System.in);
        this.customer = customer;
        this.report = report;
        this.payment = payment;
    }

    public abstract int greetCustomer();

    public void greetCustomer(Customer customer) {
        System.out.println("Dear: " + customer.getName() + " Welcome to our service!");
    }

    public Customer getCustomer() {

        return this.customer;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

}
