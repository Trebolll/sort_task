import controller.Controller;
import io.reader.ReadFile;
import io.reader.Reader;
import io.writer.WriteConsole;
import io.writer.WriteFile;
import io.writer.Writer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean isDescSorting = false;
    static boolean isStringSorting = false;
    static Writer writer;
    static List<Reader> readers = new ArrayList<>();

    private static final boolean DEBUG = false;


    public static void main(String[] args) {

        int argsCounter = 0;
        if (args.length >= 3) {

            for (int i = 0; i < 2; i++) {
                if ("-a".equalsIgnoreCase(args[argsCounter]) || "-d".equalsIgnoreCase(args[argsCounter])) {
                    if ("-a".equalsIgnoreCase(args[argsCounter])) {
                        isDescSorting = true;
                    }
                    argsCounter++;
                }

                if ("-s".equalsIgnoreCase(args[argsCounter]) || "-i".equalsIgnoreCase(args[argsCounter])) {
                    if ("-s".equalsIgnoreCase(args[argsCounter])) {
                        isStringSorting = true;
                    }
                    argsCounter++;
                }
            }

            if (DEBUG) {
                writer = new WriteConsole();
                argsCounter++;
            } else {
                writer = new WriteFile(new File(args[argsCounter++]));
            }

            List<String> inputFileNames = new ArrayList<>(Arrays.asList(args).subList(argsCounter, args.length));
            if (inputFileNames.size() < 1) {
                System.out.println("Укажите входные файлы");
            } else {
                for (String fileName : inputFileNames) {
                    readers.add(new ReadFile(new File(fileName)));
                }
            }
        } else {
            System.out.println("Отсутствуют либо превышен лимит входных параметров");
        }

        Controller controller = new Controller(
                isDescSorting,
                isStringSorting,
                writer,
                readers
        );
        controller.execute();
    }
    }

