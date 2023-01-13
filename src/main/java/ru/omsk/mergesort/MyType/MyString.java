package ru.omsk.mergesort.MyType;

public class MyString implements MyType<String> {
    @Override
    public String valueOf(String value) {
        return value.trim();
    }
}
