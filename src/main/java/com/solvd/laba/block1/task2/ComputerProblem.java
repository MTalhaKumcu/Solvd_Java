package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.CustomerExitException;
import com.solvd.laba.block1.task2.Exceptions.DiagnoseDoesNotFound;
import com.solvd.laba.block1.task2.Interfaces.IComputerInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ComputerProblem extends ComputerOptionScan implements IComputerInfo {
    private static final Logger logger = (Logger) LogManager.getLogger(ComputerProblem.class);

    private String issue;
    private double repairCost;
    private Payment payment;
    private String diagnoses;
    private QueueTicket queueTicket;
    public ScheduleAppointmentForCustomer scheduleAppointmentForCustomer =
            new ScheduleAppointmentForCustomer();
    public ServiceTechnician technician = new ServiceTechnician();

    public ReportOfDiagnostic report = new ReportOfDiagnostic();
    Map<Integer, String> issues = new HashMap<>();
    Map<String, Integer> diagnoseCostMap = new HashMap<>();

    public QueueTicket getQueueTicket() {
        return queueTicket;
    }

    public void setQueueTicket(QueueTicket queueTicket) {
        this.queueTicket = queueTicket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public int chooseComputerIssue() {
        getIssue();
        System.out.println("please select your problem");
        for (int i = 1; i <= issues.keySet().size(); i++) {
            System.out.println(i + " " + issues.get(i));
        }
        int option = scan.nextInt();

        String selectedIssue = issues.get(option);
        String diagnoses = getDiagnoses(selectedIssue);
        this.diagnoses = diagnoses;
        getRepairCost(diagnoses);


        logger.info("issue: " + selectedIssue);
        logger.info("Diagnose: " + diagnoses);
        logger.info("ticket number: " + QueueTicket.getQueueTicket());
        logger.info("Cost: " + getRepairCost());

        System.out.println("Please push 1 to get invoce ");

        return scan.nextInt();
    }

    public String getDiagnoses(String issue) {
        String diagnose;
        switch (issue) {
            case "Overheat":
                diagnose = "need to change cable";
                break;
            case "Broken Screen":
                diagnose = "need to change screen";
                break;
            case "Computer Power Does not work":
                diagnose = " need to change powersupply ";
                LocalDateTime newDateTime = LocalDateTime.now().plusDays(2);
                System.out.println(scheduleAppointmentForCustomer.scheduleAppointmentForCustomer(issue, newDateTime));
                break;
            default:
                throw new DiagnoseDoesNotFound("There is no issue like that!");
        }
        return diagnose;
    }


    public void getIssue() {
        this.issues.put(1, "Overheat");
        this.issues.put(2, "Broken Screen");
        this.issues.put(3, "Computer Power Does not work");
    }

    public void getRepairCost(String diagnoses) {

        switch (diagnoses) {
            case "need to change cable":
                this.repairCost = 50.00;
                break;
            case "need to change screen":
                this.repairCost = 75.00;
                break;

            default:
                break;
        }
    }

    public int processOption() {
        System.out.println("Welcome to our service. Please Select an option:");
        System.out.println("1 - Diagnose Problem  \nQ - Quit System");
        try {
            if (scan.hasNextInt()) {
                int option = scan.nextInt();
                if (option == 1) {
                    return chooseComputerIssue();
                } else {
                    return option;
                }
            } else {
                String customerDecision = scan.next().toUpperCase();
                if (customerDecision.equals("Q")) {
                    logger.info("Goodbye! Come Again!");
                } else {
                    logger.info("Continue with the selected option: " + customerDecision);
                }
                return 0; // Return 0 or another appropriate value based on your logic
            }
        } catch (CustomerExitException e) {
            logger.error("Invalid input! Please enter a valid option.");
            scan.next(); // Consume the invalid input
            return 0; // Return 0 or another appropriate value based on your logic
        }
    }



        @Override
        public String toString () {
            return "ComputerProblem= " +
                    "Issue= " + issue + "\n" +
                    "Repaire cost= " + repairCost + "\n" +
                    "Diagnosis= " + diagnoses;
        }


    }

