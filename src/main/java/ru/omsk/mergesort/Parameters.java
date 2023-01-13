package ru.omsk.mergesort;

import ru.omsk.mergesort.exception.ParseParamException;
import ru.omsk.mergesort.flag.OrderFlag;
import ru.omsk.mergesort.flag.TypeFlag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parameters {
    public static OrderFlag ORDER = null;
    public static TypeFlag TYPE = null;
    public static String OUTPUT_FILE_NAME = null;
    public static List<String> INPUT_LINE_NAMES = null;

    public static void parse(Iterator<String> iterator) throws ParseParamException {
        parseFlags(iterator);
        parseOutputFile(iterator);
        parseInputFiles(iterator);
    }

    public static void printParams() {
        System.out.println("Прочитаны входные параметры:");
        System.out.printf("\tПорядок сортироки: %s%n", ORDER.getOrder());
        System.out.printf("\tТип данных: %s%n", TYPE.getType());
        System.out.printf("\tИмя выходного файла: %s%n", OUTPUT_FILE_NAME);
        System.out.printf("\tСписок входных файлов: %s%n%n", String.join(", ", INPUT_LINE_NAMES));
    }

    private static void parseInputFiles(Iterator<String> iterator) throws ParseParamException {
        if (!iterator.hasNext()) {
            throw new ParseParamException("В списке параметров не указан ни один входной файл");
        }
        INPUT_LINE_NAMES = new ArrayList<>();
        while (iterator.hasNext()) {
            INPUT_LINE_NAMES.add(iterator.next());
        }
    }

    private static void parseOutputFile(Iterator<String> iterator) throws ParseParamException {
        if (!iterator.hasNext()) {
            throw new ParseParamException("В списке параметров не указан выходной файл");
        }
        OUTPUT_FILE_NAME = iterator.next();
        if (OUTPUT_FILE_NAME.startsWith("-")) {
            throw new ParseParamException(String.format("неверно считано имя выходого файла: '%s'.", OUTPUT_FILE_NAME));
        }
    }

    private static void parseFlags(Iterator<String> iterator) throws ParseParamException {
        parseFirstParam(iterator);
        if (TYPE == null) {
            parseTwoParams(iterator);
        }
    }

    private static void parseFirstParam(Iterator<String> iterator) throws ParseParamException {
        if (!iterator.hasNext()) {
            throw new ParseParamException("Нет входных параметров");
        }
        String firstParam = iterator.next();
        switch (firstParam) {
            case "-s":
                TYPE = TypeFlag.STRING;
                ORDER = OrderFlag.ASC;
                break;
            case "-i":
                TYPE = TypeFlag.INTEGER;
                ORDER = OrderFlag.ASC;
                break;
            case "-a":
                ORDER = OrderFlag.ASC;
                break;
            case "-d":
                ORDER = OrderFlag.DESC;
                break;
            default:
                throw new ParseParamException(String.format("Первый параметр может быть '-s', '-i', '-a' или '-d'. Передано: %s", firstParam));
        }
    }

    private static void parseTwoParams(Iterator<String> iterator) throws ParseParamException {
        if (!iterator.hasNext()) {
            throw new ParseParamException("Нет второго входного параметра указывающего на тип данных ('-s' или '-i')");
        }
        String twoParam = iterator.next();
        switch (twoParam) {
            case "-s":
                TYPE = TypeFlag.STRING;
                break;
            case "-i":
                TYPE = TypeFlag.INTEGER;
                break;
            default:
                throw new ParseParamException(String.format("Вторым параметром может быть '-s' или '-i'. Передано: %s", twoParam));
        }
    }
}
