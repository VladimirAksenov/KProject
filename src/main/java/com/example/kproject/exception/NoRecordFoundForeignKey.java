package com.example.kproject.exception;

public class NoRecordFoundForeignKey extends RuntimeException {

    public NoRecordFoundForeignKey(String message) {
        super(message);
    }
}
