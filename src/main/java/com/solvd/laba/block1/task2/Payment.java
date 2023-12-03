package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.Exceptions.PaymentValidationException;

import java.util.Scanner;

public class Payment {
    Scanner scan = new Scanner(System.in);
    private ComputerInfo computerInfo;
    private Invoice invoice;
    private ServiceInfo serviceInfo;
    ComputerProblem computer = new ComputerProblem();

    public Invoice getInvoice() {
        return invoice;
    }

    public Payment(double repairCost, String diagnosis) {
        this.invoice = new Invoice();
        invoice.setAmount(repairCost);
        invoice.setCurrency(" PLN ");
        invoice.setServiceInfo(ServiceInfo.getAddress());

        System.out.println(ServiceInfo.getAddress());
    }

    public int paymentOption(Invoice invoice) {
        System.out.println(invoice.getBill());
        System.out.println("Welcome to our payment department. Please chose a method to make payment.");
        System.out.println("1-Cash \n2-Credit Card");
        int paymentOption = scan.nextInt();
        switch (paymentOption) {
            case 1:
                System.out.println("Amount has been paid: "
                        + invoice.getAmount());
                sayGoodbye();
                break;
            case 2:
                System.out.println("Amount has been paid: "
                        + invoice.getAmount());
                sayGoodbye();
                break;
            default:
                throw new PaymentValidationException("Invalid payment option.");
        }
        return paymentOption;
    }

    private void sayGoodbye() {
        System.out.println("Goodbye Come Again!");
    }
}
