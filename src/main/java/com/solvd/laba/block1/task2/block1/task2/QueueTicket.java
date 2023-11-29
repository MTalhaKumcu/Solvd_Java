package com.solvd.laba.block1.task2.block1.task2;

import com.solvd.laba.block1.task2.block1.task2.Computer;
import com.solvd.laba.block1.task2.block1.task2.Customer;
import com.solvd.laba.block1.task2.block1.task2.Invoice;

public class QueueTicket {
    private Customer customer;
    private Invoice adress;
    private Customer nameSurname;
    private Computer computerBrand;
    private Computer computerModel;
    private Computer computerYear;
    private DiagnosticReport problem;

    public DiagnosticReport getProblem() {
        return problem;
    }

    public void setProblem(DiagnosticReport problem) {
        this.problem = problem;
    }

    public Invoice getAdress() {
        return adress;
    }

    public void setAdress(Invoice adress) {
        this.adress = adress;
    }

    public Customer getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(Customer nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Computer getComputerBrand() {
        return computerBrand;
    }

    public void setComputerBrand(Computer computerBrand) {
        this.computerBrand = computerBrand;
    }

    public Computer getComputerModel() {
        return computerModel;
    }

    public void setComputerModel(Computer computerModel) {
        this.computerModel = computerModel;
    }

    public Computer getComputerYear() {
        return computerYear;
    }

    public void setComputerYear(Computer computerYear) {
        this.computerYear = computerYear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void getCustomerQueueTicketPrint(int... tickets) {
        int counter = 0;
        for (int each : tickets) {
            counter += each;
        }
        System.out.println("Queue Number is: " + counter + "\n" +
                ", nameSurname= " + nameSurname + "\n" +
                ", Adress= " + adress + "\n" +
                ", computer Brand= " + computerBrand + "\n" +
                ", computer Model= " + computerModel + "\n" +
                ", computer Year= " + computerYear + "\n" +
                ", Computer Problem= " + problem);


    }

}