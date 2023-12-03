package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.ComputerValidationException;
import com.solvd.laba.block1.task2.Interfaces.IComputerInfo;
import java.util.Scanner;

public class ComputerInfo implements IComputerInfo {
    private final String brand;
    private final String model;
    private final String year;

    public ComputerInfo(String brand, String model, String year) {
        this.brand = brand;
        this.model = model;
        this.year = year;

    }

    private static final int MAX_TRIES = 3;

    public static ComputerInfo getComputerInfo() {
        String year = "";
        String brand = "";
        String model = "";
        int remainingYearTries = MAX_TRIES;

        while (remainingYearTries >= 0) {
            try {
                System.out.println("Computer Brand: ");
                brand = ComputerInfo.ConsoleHelper.readLine();
                System.out.println("Computer Model: ");
                model = ComputerInfo.ConsoleHelper.readLine();
                if (remainingYearTries >= 0) {

                    System.out.println("Computer Year: ");
                    year = validateYearOfComputer(ComputerInfo.ConsoleHelper.readLine());
                    remainingYearTries--;
                }
                break;
            } catch (ComputerValidationException e) {
                System.out.println("Invalid input: " + e.getMessage());
                if (e.getMessage().contains("Year")) {
                    if (remainingYearTries >= 0) {
                        System.out.println("You have " + remainingYearTries + " attempts remaining for Computer year.");
                        remainingYearTries--;
                    }
                }
                if (remainingYearTries == -1) {
                    System.out.println("Invalid input. Please enter a valid number for the year.");
                    System.exit(1);
                }
            }

        }

        return new ComputerInfo(brand, model, year);
    }


    public static class ConsoleHelper {
        private static final Scanner scanner = new Scanner(System.in);

        public static String readLine() {
            return scanner.next();
        }
    }

    private static String validateYearOfComputer(String year) {
        if (!year.matches("\\d+")) {
            throw new ComputerValidationException("Year must only contain numbers");
        }
        if (year.length() != 4) {
            throw new ComputerValidationException("Invalid Year length. It must contain exactly 4 digits.");
        }
        if (!year.startsWith("20")) {
            throw new ComputerValidationException("Year can start with 20.");
        }
        return year;
    }

    @Override
    public String toString() {
        return "Computer" +
                "brand=" + brand +
                ", model=" + model +
                ", year=" + year;
    }
}


