package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Interfaces.IDignoseControl;

public class ReportOfDiagnostic implements IDignoseControl {
    private String issue;
    private String diagnoses;
    private double repairCost;

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    @Override
    public String  getReportOfDiagnostic(String ReportOfDiagnosticalue) {
        return "ReportOfDiagnostic= " + "\n" +
                "issue= " + issue + "\n" +
                "diagnoses= " + diagnoses + "\n" +
                "repairCost= " + repairCost;
    }

  
}
