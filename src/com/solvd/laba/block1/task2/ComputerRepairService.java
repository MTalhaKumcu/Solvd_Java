package com.solvd.laba.block1.task2;

import java.util.HashMap;
import java.util.Map;

public class ComputerRepairService extends KumcuRepairService implements I_DiagnoseController, I_IssueController {
    private I_CustomerController ICustomerController;
    DiagnosticReport report = new DiagnosticReport();
    Map<Integer, String> issues = new HashMap();
    Map<String, Integer> diagnoseCostMap = new HashMap();

    public ComputerRepairService() {
    }

    public int greetCustomer() {
        System.out.println("Welcome to our service. Please Select an option:");
        System.out.println("1 - Diagnose Problem  \nQ - Quit System");
        int option = this.scan.next().charAt(0);
        switch (option) {
            case 1:
                return this.issueWithDevice();
            default:
                return option;
        }
    }

    public int issueWithDevice() {
        this.getIssue();
        System.out.println("Please Select the Issue.");

        int option;
        for (option = 1; option <= this.issues.keySet().size(); ++option) {
            System.out.println("" + option + " " + (String) this.issues.get(option));
        }

        option = this.scan.nextInt();
        String issue = (String) this.issues.get(option);
        String diagnosis = this.getDiagnose(issue);
        double cost = this.getCost(diagnosis);
        this.report.setIssue(issue);
        this.report.setRepairCost(cost);
        this.report.setDiagnosis(diagnosis);
        System.out.println(this.report);
        System.out.println("Please select an option");
        return this.scan.nextInt();
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
                diagnose = "need to change power button";
                break;
            default:
                throw new ValueNotFoundException("No such issue");
        }

        return diagnose;
    }

    public double getCost(String diagnose) {
        double cost;
        switch (diagnose) {
            case "need to change cable":
                cost = 50.0;
                break;
            case "need to change screen":
                cost = 75.0;
                break;
            case "need to change power button":
                cost = 100.0;
                break;
            default:
                throw new ValueNotFoundException("No such diagnose");
        }

        return cost;
    }

    public Customer getCustomer() {

        return this.ICustomerController.getCustomer();
    }

}
