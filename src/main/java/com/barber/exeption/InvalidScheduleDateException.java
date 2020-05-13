package com.barber.exeption;

public class InvalidScheduleDateException extends Exception {
    public InvalidScheduleDateException(String msg){
        super(msg);
    }
}
