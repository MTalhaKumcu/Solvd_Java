package com.solvd.laba.block1.task2;

public class Main {
    public static void main(String[] args) {

        try {
            Customer customer = Customer.getCustomerInput();
            System.out.println(customer);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
        Computer computer = Computer.getComputerInput();
        System.out.println(computer);

        ComputerRepairService service = new ComputerRepairService();
        int decision = service.greetCustomer();


        if (decision == 1) {
            PaymentDepartment payment = new PaymentDepartment(service.report);
            payment.greetCustomer();

        } else if (Character.toUpperCase((char) decision) == 'Q') {
            System.out.println("Goodbye Come again!");
        } else {
            System.out.println("Continue with the selected option: " + decision);
        }

    }

}