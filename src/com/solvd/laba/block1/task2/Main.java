package com.solvd.laba.block1.task2;

public class Main {
    public static void main(String[] args) {

        ComputerRepairService service = new ComputerRepairService();
        int decision = service.greetCustomer();
        PaymentDepartment payment = new PaymentDepartment(service.report);
        if (decision == 1) {
            payment.greetCustomer();
        }

        System.out.println("Goodbye Come again!");
    }
}