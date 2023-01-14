import io.reader.ReadFile;
import io.writer.WriteConsole;
import io.writer.WriteFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLineRunner {

    private static final boolean DEBUG = false;
    void parse(String[] args) {
        int argsCounter = 0;

        if (args.length >= 3) {

            for (int i = 0; i < 2; i++) {
                if ("-a".equalsIgnoreCase(args[argsCounter]) || "-d".equalsIgnoreCase(args[argsCounter])) {
                    if ("-d".equalsIgnoreCase(args[argsCounter])) {
                        Main.isDescSorting = true;
                    }
                    argsCounter++;
                }

                if ("-s".equalsIgnoreCase(args[argsCounter]) || "-i".equalsIgnoreCase(args[argsCounter])) {
                    if ("-s".equalsIgnoreCase(args[argsCounter])) {
                        Main.isStringSorting = true;
                    }
                    argsCounter++;
                }
            }

            if (DEBUG) {
                Main.writer = new WriteConsole();
                argsCounter++;
            } else {
                Main.writer = new WriteFile(new File(args[argsCounter++]));
            }

            List<String> inputFileNames = new ArrayList<>(Arrays.asList(args).subList(argsCounter, args.length));
            if (inputFileNames.size() < 1) {
                System.out.println("Не найдены входные файлы");
            } else {
                for (String fileName : inputFileNames) {
                    Main.readers.add(new ReadFile(new File(fileName)));
                }
            }
        } else {
            System.out.println("Неверные параметры");
        }
    }
}
