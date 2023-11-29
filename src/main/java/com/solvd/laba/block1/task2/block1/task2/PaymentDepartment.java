package com.solvd.laba.block1.task2.block1.task2;
import com.solvd.laba.block1.task2.block1.task2.exceptions.InvalidPaymentException;

public class PaymentDepartment extends KumcuRepairService {
    private Invoice invoice;
    private double amount;

    public PaymentDepartment(DiagnosticReport report) {
        this.amount = report.getRepairCost();
        Invoice.setInvoice(report.getRepairCost(),
                   " $", " aleja Jerozolimskie 98");
    }

    public double getAmount() {

        return this.amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }


    public int greetCustomer() {
        System.out.println(Invoice.getBill());
        System.out.println("Welcome to our payment department. Please chose a method to make payment.");
        System.out.println("1-Cash \n2-Credit Card");
        int option = this.scan.nextInt();
        switch (option) {
            case 1:
                System.out.println("Please pay amount by cash: "
                        + this.amount);
                break;
            case 2:
                System.out.println("Please pay amount by card: "
                        + this.amount);
                break;
            default:
                throw new InvalidPaymentException ("Invalid payment option.");
        }

        return option;
    }
}
