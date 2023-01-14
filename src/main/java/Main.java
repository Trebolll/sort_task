import controller.Controller;
import io.reader.Reader;
import io.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean isDescSorting = false;
    static boolean isStringSorting = false;
    static Writer writer;
    static List<Reader> readers = new ArrayList<>();

    public static void main(String[] args) {

        new CommandLineRunner().parse(args);

        Controller controller = new Controller(
                isDescSorting,
                isStringSorting,
                writer,
                readers
        );
        controller.execute();
    }
    }

