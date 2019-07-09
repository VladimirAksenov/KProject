package com.example.kproject.exception;

public class NoRecordFoundToDelete extends RuntimeException {

    public NoRecordFoundToDelete(String message) {
        super(message);
    }
}
