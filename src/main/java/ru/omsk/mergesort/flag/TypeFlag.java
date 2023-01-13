package ru.omsk.mergesort.flag;

public enum TypeFlag {
    INTEGER("-i"),
    STRING("-s");

    private final String typeFlag;

    TypeFlag(String flag) {
        this.typeFlag = flag;
    }

    public String getType() {
        return this.typeFlag;
    }
}
