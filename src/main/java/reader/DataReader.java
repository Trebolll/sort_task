package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public interface DataReader<T> {

    List<T> getList();

    default void readFiles(List<File> files) {

        for (File file : files) {
            if (file.isFile()) {
                BufferedReader inputStream = null;
                String line;
                try {
                    inputStream = new BufferedReader(new FileReader(file));
                    while ((line = inputStream.readLine()) != null) {
                        if (!line.trim().isBlank()) {
                            addToCollection(line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    void addToCollection(String line);


}
