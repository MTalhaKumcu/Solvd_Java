package com.solvd.laba.block1.task2;

public class QueueTicket {
    private ComputerInfo computer;
    private CustomerInfo customer;
    private ComputerProblem pcProblem;
    private ServiceTechnician technician;
    public static int ticketNumber;


    public ComputerInfo getComputer() {
        return computer;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public ComputerProblem getPcProblem() {
        return pcProblem;
    }

    public ServiceTechnician getTechnician() {
        return technician;
    }


    public static int getQueueTicket() {
        return ++ticketNumber;
    }

    @Override
    public String toString() {
        return "Queue Ticket Number= " + "ticket degerini yaz" + "\n" +
                "Computer information= " + computer + "\n" +
                "Customer= " + customer + "\n" +
                "Computer Problem=" + pcProblem + "\n" +
                "Technician= " + technician;
    }
}
