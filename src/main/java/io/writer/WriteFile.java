package io.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteFile implements Writer {
    private File file;

    public WriteFile(File file) {
        this.file = file;
    }

    @Override
    public void write(String item) {
        if (file == null) {
            System.out.println("Файл не существует");
            return;
        }

        if (item == null) {
            System.out.println("Отсутствует элемент для записи в файл");
            return;
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(item + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


