package com.solvd.laba.block1.task2.block1.task2;

import com.solvd.laba.block1.task2.block1.task2.exceptions.ValueNotFoundException;
import com.solvd.laba.block1.task2.block1.task2.interfaces.IDiagnoseController;
import com.solvd.laba.block1.task2.block1.task2.interfaces.IIssueController;

import java.util.HashMap;
import java.util.Map;


public class ComputerRepair extends KumcuRepairService implements IDiagnoseController, IIssueController {
   private static final Logger logger = LogManager.getLogger(ComputerRepair.class);

    private com.solvd.laba.block1.task2.block1.task2.interfaces.ICustomerController ICustomerController;
    DiagnosticReport report = new DiagnosticReport();
    Map<Integer, String> issues = new HashMap<>();
    Map<String, Integer> diagnoseCostMap = new HashMap<>();



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
        for (int i = 1; i <= issues.keySet().size(); i++){
            System.out.println(i + " " + issues.get(i));
        }
        int option = scan.nextInt();
        String issue = issues.get(option);
        String diagnosis = getDiagnose(issue);
        double cost = getCost(diagnosis);

        report.setIssue(issue);
        report.setRepairCost(cost);
        report.setDiagnosis(diagnosis);

        System.out.println(report);

        System.out.println("Please select an option");

        return scan.nextInt();

    }

    public void getIssue() {
        this.issues.put(1, "Overheat");
        this.issues.put(2, "Broken Screen");
        this.issues.put(3, "Does not start");
    }

    public String getDiagnose(String issue){
        String diagnose;
        switch (issue){
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

    public double getCost(String diagnose){
        double cost;
        switch (diagnose){
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
