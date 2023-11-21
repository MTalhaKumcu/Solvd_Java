package com.solvd.laba.block1.task2.block1.task2;

public class RepairTechnician {
    private String name;
    private String expertise;
    private double hourlyRate;

    public RepairTechnician(String name, String expertise, double hourlyRate) {
        this.name = name;
        this.expertise = expertise;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return this.expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public double getHourlyRate() {
        return this.hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}
