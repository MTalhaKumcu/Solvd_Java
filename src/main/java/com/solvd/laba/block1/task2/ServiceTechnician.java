package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.Exceptions.TechnicianException;

import java.util.Scanner;

public class ServiceTechnician extends ComputerOptionScan {
    private String selection;

    public ServiceTechnician() {
    }


    public ServiceTechnician(String selection) {
        this.selection = selection;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static class ConsoleHelper {

        public static String readLine() {
            return scanner.next();
        }
    }

    private static int MAX_TRIES = 3;

    public static ServiceTechnician getSelectInfo() {
        String selection = "";
        while (MAX_TRIES >= 0) {
            try {
                if (MAX_TRIES > 0) {
                    System.out.println("Select Technician: ");
                    selection = validateTechnician(ConsoleHelper.readLine());
                    MAX_TRIES--;
                    break;
                }
            } catch (TechnicianException e) {
                System.out.println("Invalid input: " + e.getMessage());
                if (e.getMessage().contains("selection")) {
                    if (MAX_TRIES >= 0) {
                        System.out.println("You have " + MAX_TRIES + " attempts remaining to select technician. ");
                        MAX_TRIES--;

                    }
                }
                if (MAX_TRIES >= -1) {
                    System.out.println("Too many invalid attempts. Exiting the application.");
                    System.exit(1);
                }
            }
        }

        return new ServiceTechnician(selection);
    }

    private static String validateTechnician(String select) {
        if (!select.matches("\\d+")) {
            throw new TechnicianException("Invalid selection . its must be between 1-8. ");
        }
        if (!select.matches("[1-8]")) {
            throw new TechnicianException("Invalid selection . its must be between 1-8. ");
        }
        return select;
    }

    public void selectedTechnician() {
        System.out.println("Your technician is: ");

        if (selection.contains("1")) {
            System.out.println("Talha");
        } else if (selection.contains("2")) {
            System.out.println("Sergey");
        } else if (selection.contains("3")) {
            System.out.println("Deniz");
        } else if (selection.contains("4")) {
            System.out.println("Vadim");
        } else if (selection.contains("5")) {
            System.out.println("Alexey");
        } else if (selection.contains("6")) {
            System.out.println("Andrey");
        } else if (selection.contains("7")) {
            System.out.println("Alex");
        } else if (selection.contains("8")) {
            System.out.println("Michalina");
        } else {
            System.out.println("Invalid selection");
        }


    }
}




