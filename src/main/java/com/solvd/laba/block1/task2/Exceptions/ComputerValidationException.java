package com.solvd.laba.block1.task2.Exceptions;

import java.util.InputMismatchException;

public class ComputerValidationException extends InputMismatchException {
    public  ComputerValidationException(String message) {
        super(message);
    }
}
