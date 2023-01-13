package ru.omsk.mergesort;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;

import ru.omsk.mergesort.exception.FileReadException;
import ru.omsk.mergesort.exception.ParseParamException;
import ru.omsk.mergesort.flag.TypeFlag;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start sorting...");

        try {
            Iterator<String> iterator = Arrays.stream(args).iterator();
            Parameters.parse(iterator);
            Parameters.printParams();

            Type type;
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort();

            System.out.println("End sorting");

        }
        catch (ParseParamException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Формат передаваемых параметров: '[-d|-a] <-c|-i> <out> <in1, in2, ...>'");
        }
        catch (FileReadException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Проверьте названия входящих файлов");
        }
    }


}