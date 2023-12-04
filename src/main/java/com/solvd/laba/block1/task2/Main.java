package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Enums.TechnicianEnum;
import com.solvd.laba.block1.task2.Enums.WeekDaysEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        WeekDaysEnum.writeWeekDays();
        TechnicianEnum.choseTechnician();

        CustomerInfo customerInfo = CustomerInfo.getCustomerInput();
        ComputerInfo computerInfo = ComputerInfo.getComputerInfo();

        ComputerProblem service = new ComputerProblem();
        int customerDesicion = service.processOption();

        if (customerDesicion == 1) {
            Payment payment = new Payment(service.getRepairCost(), service.getDiagnoses());
            payment.paymentOption(payment.getInvoice());
        } else if (Character.toUpperCase((char) customerDesicion) == 'Q') {
            logger.info("Goodbye Come Again!");
        } else {
            logger.info("Continue with the selected option: " + customerDesicion);
        }
    }
}