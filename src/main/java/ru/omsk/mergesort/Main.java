package ru.omsk.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import ru.omsk.mergesort.exception.ParseParamException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start sorting...");

        Iterator<String> iterator = Arrays.stream(args).iterator();
        try {
            parseParams(iterator);
        } catch (ParseParamException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Формат передаваемых параметров: '[-d|-a] <-c|-i> <out> <in1, in2, ...>'");
        }

    }

    private static void parseParams(Iterator<String> iterator) throws ParseParamException {
        if (!iterator.hasNext()) {
            throw new ParseParamException("Нет входных параметров");
        }
        String param = iterator.next();
        Boolean order = null;
        String type = null;
        switch (param) {
            case "-s":
            case "-i":
                type = param;
                order = true;
                break;
            case "-a":
                order = true;
                break;
            case "-d":
                order = false;
                break;
            default:
                throw new ParseParamException(String.format("Первый параметр может быть '-s', '-i', '-a' или '-d'. Передано: %s", param));
        }
        if (type == null) {
            if (!iterator.hasNext()) {
                throw new ParseParamException("Нет второго входного параметра указывающего на тип данных ('-s' или '-i')");
            }
            type = iterator.next();
        }

        if (!iterator.hasNext()) {
            throw new ParseParamException("В списке параметров не указан выходной файл");
        }
        var outputFileName = iterator.next();
        if (outputFileName.startsWith("-")) {
            throw new ParseParamException(String.format("неверно считано имя выходого файла: '%s'.", outputFileName));
        }
        if (!iterator.hasNext()) {
            throw new ParseParamException("В списке параметров не указан ни один входной файл");
        }
        var inputFileNames = new ArrayList<String>();
        while (iterator.hasNext()) {
            inputFileNames.add(iterator.next());
        }

        System.out.println("Прочитаны входные параметры:");
        System.out.printf("\tПорядок сортироки: %s%n", order);
        System.out.printf("\tТип данных: %s%n", type);
        System.out.printf("\tИмя выходного файла: %s%n", outputFileName);
        System.out.printf("\tСписок входных файлов: %s%n%n", String.join(", ", inputFileNames));
    }
}