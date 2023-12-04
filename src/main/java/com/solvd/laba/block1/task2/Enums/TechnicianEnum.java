package com.solvd.laba.block1.task2.Enums;

public enum TechnicianEnum {
    TALHA("Talha",1),
    SERGEY("Sergey",2),
    DENIZ("Deniz",3),
    VADIM("Vadim",4),
    ALEXEY("Alexey",5),
    ANDREY("Andrey",6),
    ALEX("Alex",7),
    MICHALINA("Michalina",8);
    private final String name;
    private final int numberOfTechnician;

    TechnicianEnum(String name, int numberOfTechnician) {
        this.name = name;
        this.numberOfTechnician= numberOfTechnician;
    }

    public String getName() {
        return name;
    }
    public int getNumberOfTechnician(){
        return numberOfTechnician;
    }

    public static void choseTechnician() {

        for (TechnicianEnum technician : TechnicianEnum.values()) {
            System.out.println("----------------------" + "\n"
                    + "Avaliable Technician: " + technician.name()+" "+technician.getNumberOfTechnician());

        }
    }
}
