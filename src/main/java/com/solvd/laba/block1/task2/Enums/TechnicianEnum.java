package com.solvd.laba.block1.task2.Enums;

public enum TechnicianEnum {
    TALHA("Talha"),
    SERGEY("Sergey"),
    DENIZ("Deniz"),
    VADIM("Vadim"),
    ALEXEY("Alexey"),
    ANDREY("Andrey"),
    ALEX("Alex"),
    MICHALINA("Michalina");
    private final String name;

    TechnicianEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void choseTechnician() {

        for (TechnicianEnum technician : TechnicianEnum.values()) {
            System.out.println("----------------------" + "\n"
                    + "Avaliable Technician: " + technician.name() + "\n");

        }
    }
}
