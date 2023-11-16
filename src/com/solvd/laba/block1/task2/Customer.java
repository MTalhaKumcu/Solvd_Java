package com.solvd.laba.block1.task2;

import java.util.Objects;
import java.util.Scanner;

public class Customer implements I_CustomerController {

    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer getCustomer() {
        return this;
    }

    private static final int MAX_TRIES = 3;

    public static Customer getCustomerInput() {

        String name = "";
        String email = "";
        String phoneNumber = "";

        int remainingNameTries = MAX_TRIES;
        int remainingEmailTries = MAX_TRIES;
        int remainingPhoneNumberTries = MAX_TRIES;

        while (remainingNameTries >= 1 ||
                remainingEmailTries >= 1 ||
                remainingPhoneNumberTries >= 1) {

            try {
                if (remainingNameTries >= 1) {
                    System.out.println("Enter Customer Name Surname:");
                    name = validateName(ConsoleHelper.readLine());
                    remainingNameTries--;
                }
                if (
                        remainingEmailTries >= 1) {
                    System.out.println("Enter Customer Email:");
                    email = validateEmail(ConsoleHelper.readLine());
                    remainingEmailTries--;
                }
                if (remainingPhoneNumberTries >= 1) {
                    System.out.println("Enter Customer Phone Number:");
                    phoneNumber = validateNumber(ConsoleHelper.readLine());
                    remainingPhoneNumberTries--;
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                if (e.getMessage().contains("Name")) {
                    if (remainingNameTries >= 1) {
                        System.out.println("You have " + remainingNameTries + " attempts remaining for Name Surname.");
                        remainingNameTries--;
                    }
                } else if (e.getMessage().contains("Email")) {
                    if (remainingEmailTries >= 1) {
                        System.out.println("You have " + remainingEmailTries + " attempts remaining for Email.");
                        remainingEmailTries--;
                    }
                } else if (e.getMessage().contains("Number")) {
                    if (remainingPhoneNumberTries >= 1) {
                        System.out.println("You have " + remainingPhoneNumberTries + " attempts remaining for Phone Number.");
                        remainingPhoneNumberTries--;
                    }
                }
                if (remainingNameTries == 0 ||
                        remainingEmailTries == 0 ||
                        remainingPhoneNumberTries == 0) {
                    System.out.println("Too many invalid attempts. Exiting the application.");
                    System.exit(1);
                }
            }
        }
        return new Customer(name, email, phoneNumber);
    }

    private static String validateName(String name) {
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Name must only contain letters.");
        }
        return name;
    }

    private static String validateEmail(String email) {

        if (!email.matches("[a-zA-Z0-9]+@gmail\\.com")) {
            throw new IllegalArgumentException("Invalid email format. Email must end with @gmail.com, Letters and Numbers");
        }
        return email;
    }

    private static String validateNumber(String number) {

        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("Number must only contain numbers");
        }
        return number;
    }

    public static class ConsoleHelper {
        private static final Scanner scanner = new Scanner(System.in);

        public static String readLine() {
            return scanner.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Customer Information:\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n";
    }
}


