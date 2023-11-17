package main.java.com.solvd.laba.block1.task2;

public class DiagnosticReport {
    private String issue;
    private String diagnosis;
    private double repairCost;

    public DiagnosticReport(String issue, String diagnosis, double repairCost) {
        this.issue = issue;
        this.diagnosis = diagnosis;
        this.repairCost = repairCost;
    }

    public String getIssue() {

        return this.issue;
    }

    public DiagnosticReport() {
    }

    public void setIssue(String issue) {

        this.issue = issue;
    }

    public String getDiagnosis() {

        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {

        this.diagnosis = diagnosis;
    }

    public Double getRepairCost() {

        return this.repairCost;
    }

    public void setRepairCost(double repairCost) {

        this.repairCost = repairCost;
    }

    public String toString() {
        return "DiagnosticReport = \nissue= " +
                this.issue + "\ndiagnosis= " +
                this.diagnosis + "\nrepairCost= " +
                this.repairCost;
    }
}
