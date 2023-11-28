package com.solvd.laba.block1.task2.block1.task2;

import com.solvd.laba.block1.task2.block1.task2.interfaces.IComputerController;
import com.solvd.laba.block1.task2.block1.task2.exceptions.InvalidComputerValidationException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Computer implements IComputerController {
    private String brand;
    private String model;
    private String year;


    public Computer(String brand, String model, String year) {
        this.brand = brand;
        this.model = model;
        this.year = year;

    }

    public String getBrand() {

        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private static final int MIN_YEAR = 2000;

    public static Computer getComputerInput() {
        String brand;
        String model;
        String year;


        try {
            System.out.println("Enter computer brand:");
            brand = Computer.ConsoleHelper.readLine();

            System.out.println("Enter computer model:");
            model = Computer.ConsoleHelper.readLine();

            System.out.println("Enter computer year:");
            year = validateYearOfComputer(Computer.ConsoleHelper.readLine());

            return new Computer(brand, model, year);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for the year.");
            return null;
        }

    }

    public static class ConsoleHelper {
        private static final Scanner scanner = new Scanner(System.in);

        public static String readLine() {
            return scanner.next();
        }
    }

    public static String validateYearOfComputer(String year) {
        if (!year.matches("\\d+")) {
            throw new InvalidComputerValidationException("Year must only contain numbers");
        }
        if (year.length() != 4) {
            throw new InvalidComputerValidationException("Invalid Year length. It must contain exactly 4 digits.");
        }
        if (!year.startsWith("20")) {
                throw new InvalidComputerValidationException("Year cannot start with 20.");
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
