package ru.omsk.mergesort.exception;

import lombok.Getter;

@Getter
public class FileReadException extends Exception {
    public FileReadException(String message) {
        super(message);
    }

}
