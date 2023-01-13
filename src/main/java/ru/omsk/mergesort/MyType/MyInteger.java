package ru.omsk.mergesort.MyType;

public class MyInteger implements MyType<Integer>{
    @Override
    public Integer valueOf(String value) {
        return Integer.valueOf(value.trim());
    }
}
