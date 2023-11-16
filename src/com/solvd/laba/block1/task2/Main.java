package com.solvd.laba.block1.task2;

public class Main {
    public static void main(String[] args) {

        try {
            Customer customer = Customer.getCustomerInput();
            System.out.println(customer.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
        ComputerRepairService service = new ComputerRepairService();
        int decision = service.greetCustomer();
        PaymentDepartment payment = new PaymentDepartment(service.report);

        if (decision == 1) {
            payment.greetCustomer();
        }else if (Character.toUpperCase((char) decision) == 'Q'){
            System.out.println("Goodbye Come again!");
        }else {
            System.out.println("Continue with the selected option: " + decision);
        }


    }

}