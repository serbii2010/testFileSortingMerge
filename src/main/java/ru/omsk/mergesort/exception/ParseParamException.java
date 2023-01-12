package ru.omsk.mergesort.exception;

public class ParseParamException extends Exception {
    private final String message;

    public ParseParamException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
