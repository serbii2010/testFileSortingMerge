package ru.omsk.mergesort.flag;

public enum OrderFlag {
    ASC("-a"),
    DESC("-d");

    private final String orderFlag;

    OrderFlag(String flag) {
        this.orderFlag = flag;
    }

    public String getOrder() {
        return this.orderFlag;
    }
}
