package ru.omsk.mergesort;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MergeSort<T> {
    private TreeMap<T, BufferedReader> sortedMap;

    private final List<String> inputFileName;
    private final String outputFileName;

    public MergeSort(List<String> inputFileName, String outputFileName) {
        this.inputFileName = new ArrayList<>(inputFileName);
        this.outputFileName = outputFileName;
        

    }

    public void sort() {

    }
}
