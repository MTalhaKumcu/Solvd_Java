package com.solvd.laba.block1.task2.block1.task2.Node;

import com.solvd.laba.block1.task2.block1.task2.Computer;
import com.solvd.laba.block1.task2.block1.task2.ComputerRepair;
import com.solvd.laba.block1.task2.block1.task2.Customer;
import com.solvd.laba.block1.task2.block1.task2.PaymentDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Customer customer = Customer.getCustomerInput();
        Computer computer = Computer.getComputerInput();

        ComputerRepair service = new ComputerRepair();
        int decision = service.greetCustomer();


        if (decision == 1) {
            PaymentDepartment payment = new PaymentDepartment(service.report());
            payment.greetCustomer();

        } else if (Character.toUpperCase((char) decision) == 'Q') {
            logger.info("Goodbye Come again!");
        } else {
            logger.info("Continue with the selected option: " + decision);
        }

    }

}