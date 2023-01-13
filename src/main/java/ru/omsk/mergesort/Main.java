package ru.omsk.mergesort;

import ru.omsk.mergesort.exception.FileReadException;
import ru.omsk.mergesort.exception.ParseParamException;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Iterator<String> iterator = Arrays.stream(args).iterator();
            Parameters.parse(iterator);
            Parameters.printParams();

            System.out.println("Инициализация входных файлов...");
            MergeSort mergeSort = new MergeSort();
            System.out.println("Инициализация входных файлов завершена!");
            System.out.println("Запускаю сортировку...");
            mergeSort.sort();
            System.out.println("Сортировка успешно завершена!");
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