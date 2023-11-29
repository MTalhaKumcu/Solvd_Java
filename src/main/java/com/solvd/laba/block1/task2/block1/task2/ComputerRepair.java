package com.solvd.laba.block1.task2.block1.task2;

import com.solvd.laba.block1.task2.block1.task2.exceptions.ValueNotFoundException;
import com.solvd.laba.block1.task2.block1.task2.interfaces.IDiagnoseController;
import com.solvd.laba.block1.task2.block1.task2.interfaces.IIssueController;
import com.solvd.laba.block1.task2.block1.task2.interfaces.ICustomerController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class ComputerRepair extends KumcuRepairService implements IDiagnoseController, IIssueController {
    private static final Logger logger = (Logger) LogManager.getLogger(ComputerRepair.class);

    private ICustomerController ICustomerController;
    public DiagnosticReport report = new DiagnosticReport();
    Map<Integer, String> issues = new HashMap<>();
    Map<String, Integer> diagnoseCostMap = new HashMap<>();
    private KumcuRepairService serviceRequest;

    private Appointment appointment;

    private QueueTicket queueTicket;

    public KumcuRepairService getServiceRequest() {
        return serviceRequest;
    }


    public void setServiceRequest(KumcuRepairService serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {

        this.appointment = appointment;
    }

    public QueueTicket getQueueTicket() {
        return queueTicket;
    }

    public void setQueueTicket(QueueTicket queueTicket) {
        this.queueTicket = queueTicket;
    }

    @Override
    public int greetCustomer() {
        System.out.println("Welcome to our service. Please Select an option:");
        System.out.println("1 - Diagnose Problem  \nQ - Quit System");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                return issueWithDevice();
            default:
                break;
        }

        return option;
    }

    public int issueWithDevice() {
        getIssue();
        System.out.println("Please Select the Issue.");
        for (int i = 1; i <= issues.keySet().size(); i++) {
            System.out.println(i + " " + issues.get(i));
        }
        int option = scan.nextInt();

        String issue = issues.get(option);
        String diagnosis = getDiagnose(issue);
        double cost = getCost(diagnosis);

        // report.setIssue(issue);
        //report.setDiagnosis(diagnosis);
        //set repairCost incele cikarinca fiyarlar 0 laniyor ekleyince exception veriyor
        // report.setRepairCost(cost);
        //System.out.println(report);
        logger.warn("Issue: " + issue);
        logger.warn("Diagnosis: " + diagnosis);
        logger.info("Cost: " + cost);

        System.out.println("Please select an option\n 1 - Invoice");

        return scan.nextInt();

    }


    public void getIssue() {
        this.issues.put(1, "Overheat");
        this.issues.put(2, "Broken Screen");
        this.issues.put(3, "Does not start");
    }

    public String getDiagnose(String issue) {
        String diagnose;
        switch (issue) {
            case "Overheat":
                diagnose = "need to change cable";
                break;
            case "Broken Screen":
                diagnose = "need to change screen";
                break;
            case "Does not start":
                diagnose = diagnoseFailCase(issue);
                break;
            default:
                throw new ValueNotFoundException("No such issue");
        }
        return diagnose;
    }


    public String diagnoseFailCase(String issue) {

        if (issue.contains("Does not start")) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime newDateTime = currentDateTime.plusDays(2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String formattedDate = newDateTime.format(formatter);
            System.out.println("There is no item. Your appointment date is : " + formattedDate);
        }
        return issue;
    }

    public int queueTicket(int tickets, String issue) {
        if (!issue.equals(diagnoseFailCase(issue))) {
            queueTicket.getCustomerQueueTicketPrint();
        }

        return tickets;

    }

    public double getCost(String diagnose) {
        double cost;
        switch (diagnose) {
            case "need to change cable":
                cost = 50;
                break;
            case "need to change screen":
                cost = 75;
                break;
            case "need to change power button":
                cost = 100;
                break;
            default:
                throw new ValueNotFoundException("No such diagnose");

        }
        return cost;
    }

    public Customer getCustomer() {
        return ICustomerController.getCustomer();
    }


}
