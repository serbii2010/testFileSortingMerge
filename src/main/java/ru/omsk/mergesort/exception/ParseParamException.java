package ru.omsk.mergesort.exception;

import lombok.Getter;

@Getter
public class ParseParamException extends Exception {
    public ParseParamException(String message) {
        super(message);
    }

}
