package sorting;


import reader.IntegerDataReader;
import reader.StringDataReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortManager {

    // считанные параметры будут записаны в эти переменные
    private SortDirection sortDirection = SortDirection.ASC; // дефолтное значение
    private DataType dataType = DataType.STRING; // дефолтное значение
    private File outputFile; // для записи результата
    private List<File> inputFiles;


    public void execute() throws IOException {

        switch (dataType) {
            case INT -> sortIntegers();
            case STRING -> sortStrings();
        }


    }

    private void sortStrings() throws IOException {

        StringDataReader dataReader = new StringDataReader(inputFiles);

        List<String> list = dataReader.getList();

        MergeSort<String> mergeSort = new MergeSort<>(list);

        writeToFile(mergeSort.sortedList());

    }

    private void sortIntegers() throws IOException {
        IntegerDataReader dataReader = new IntegerDataReader(inputFiles);

        List<Integer> list = dataReader.getList();

        MergeSort<Integer> mergeSort = new MergeSort<>(list);

        writeToFile(mergeSort.sortedList());
    }
    private void writeToFile(List list) throws IOException {
        FileWriter writer = new FileWriter(outputFile);
        for (Object str : list) { // любой объект автоматически будет представлять как String, потому что идет запись в текстовый файл
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        System.out.println("Файл сохранен: " + outputFile);
    }



    public void init(String[] args) throws Exception {

        if (args.length >= 3) { // минимум должно быть 3 параметра согласно условию задачи

            // можно было использовать стримы, но для упрощения реализовал считывание параметров через стандартные циклы

            // определяем сортировку
            sortDirection = initSortDirection(args);
            System.out.println("Сортировка: " + sortDirection);

            // определяем тип данных
            dataType = initDataType(args);
            System.out.println("Тип данных: " + dataType);

            outputFile = initOutputFile(args);
            System.out.println("Исходящий файл: " + outputFile);

            inputFiles = initInputFiles(args);
            System.out.println("Входящие файлы: " + inputFiles);


        } else {
            System.out.println("Неверное количество параметров. Минимальный пример: -s out.txt in1.txt");
        }

        System.out.println("Параметры считаны корректно");

    }

    private List<File> initInputFiles(String[] args) throws Exception {

        ArrayList<File> files = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && args[i].contains(".")) { // считает первый параметр с точкой (значит имя файла)
                String filePath = args[i];
                files.add(new File(filePath));
            }
        }

        // т.к. этот параметр обязательный - то в случае отсутствия хотя бы 1 параметра (пустая коллекция), выводим ошибку
        if (files.isEmpty()) {
            throw new Exception("Параметры для входящих файлов не найдены. Нужно указывать с расширением, например .txt");
        }

        return files;
    }

    private File initOutputFile(String[] args) throws Exception {

        ArrayList<File> outputFiles = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && args[i].contains(".")) { // считает первый параметр с точкой (значит имя файла)
                String filePath = args[i];
                args[i] = null; // удаляем этот параметр, чтобы он не мешался в дальнейшем (и можно было получить все параметры для входящих файлов)
                return new File(filePath);
            }
        }

        // т.к. этот параметр обязательный - то в случае отсутствия параметра, выводим ошибку
        throw new Exception("Параметр для исходящего файла не найден. Нужно указывать с расширением, например .txt");
    }

    private DataType initDataType(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && args[i].equalsIgnoreCase("-i") && !args[i].contains(".")) { // если параметр не содержит точку (значит имя файла)
                return DataType.INT;
            }

            if (args[i] != null && args[i].equalsIgnoreCase("-s") && !args[i].contains(".")) { // если параметр не содержит точку (значит имя файла)
                return DataType.STRING;
            }
        }
        // т.к. этот параметр обязательный - то в случае отсутствия параметра, выводим ошибку
        throw new Exception("Параметр для типов данных не найдены!");
    }
    // определяем сортировку из параметров (считывает все параметры и находит из них нужный)
    private SortDirection initSortDirection(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] != null && args[i].equalsIgnoreCase("-d") && !args[i].contains(".")) { // если параметр не содержит точку (как в имени файла)
                return SortDirection.DESC;
            }
        }
        // т.к. этот параметр необязательный - то просто возвращаем дефолтное значение
        return SortDirection.ASC;
    }
}
