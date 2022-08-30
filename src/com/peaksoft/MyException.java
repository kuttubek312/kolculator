package com.peaksoft;

public class MyException extends Exception {
    public MyException() {
        System.out.println("на ноль делить нельзя брат");
    }

    public MyException(String message) {
        super(message);
    }

}