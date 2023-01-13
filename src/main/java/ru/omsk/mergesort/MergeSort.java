package ru.omsk.mergesort;

import lombok.Getter;
import lombok.Setter;
import ru.omsk.mergesort.exception.FileReadException;
import ru.omsk.mergesort.exception.ParseFileException;
import ru.omsk.mergesort.exception.ParseParamException;
import ru.omsk.mergesort.flag.OrderFlag;
import ru.omsk.mergesort.flag.TypeFlag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Predicate;

import static ru.omsk.mergesort.flag.OrderFlag.ASC;
import static ru.omsk.mergesort.flag.OrderFlag.DESC;

@Getter
@Setter
public class MergeSort<T extends Comparable<T>> {
    private TreeMap<T, List<BufferedReader>> sortedMap;
    private final String fileDirectory = System.getenv("FILE_DIRECTORY");

    private final List<String> inputFileNames;
    private final String outputFileName;

    public MergeSort() throws FileReadException {
        this.inputFileNames = new ArrayList<>(Parameters.INPUT_LINE_NAMES);
        this.outputFileName = Parameters.OUTPUT_FILE_NAME;
        initMap();
    }

    public void sort() {

    }

    private void initMap() throws FileReadException {
        Comparator<T> comparator = getComparator();
        sortedMap = new TreeMap<>(comparator);

        for (String inputFile : this.inputFileNames) {
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(String.join("/", fileDirectory, inputFile))
                );

                String line = bufferedReader.readLine();
                if (line != null) {
                    T keyMap = lineToValue(line);
                    if (sortedMap.containsKey(keyMap)) {
                        List<BufferedReader> bufferedReadersElems = sortedMap.get(keyMap);
                        bufferedReadersElems.add(bufferedReader);
                    } else {
                        sortedMap.put(keyMap, new ArrayList<>(Collections.singletonList(bufferedReader)));
                    }
                }
            } catch (FileNotFoundException exception) {
                throw new FileReadException(String.format(
                        "Файл '%s' не найден. работа будет остановлена!",
                        String.join("/", fileDirectory, inputFile))
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseFileException e) {
                System.out.println(e.getMessage());
                System.out.println("Файл '%s' имеет неверный формат данных и будет проигнорирован");
            }
        }
    }

    private Comparator<T> getComparator() {
        return (o1, o2) -> {
            if (DESC.equals(Parameters.ORDER)) {
                return o2.compareTo(o1);
            }
            return o1.compareTo(o2);
        };
    }

    private T lineToValue(String line) throws ParseFileException {
        if (TypeFlag.INTEGER.equals(Parameters.TYPE)) {
            try {
                return (T) Integer.valueOf(line.trim());
            } catch (NumberFormatException exception) {
                throw new ParseFileException(
                        String.format("Неверный формат данных в файле. ожидаются целые числа. Считано: '%s'", line)
                );
            }
        }
        return (T) line.trim();
    }


}
