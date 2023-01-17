package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringDataReader implements DataReader<String> {

    private List<String> list = new ArrayList<>();

    public StringDataReader(List<File> fileList) throws IOException {
        readFiles(fileList);
    }

    @Override
    public void addToCollection(String line) {
        list.add(line);
    }

    @Override
    public List<String> getList() {
        return list;
    }
}
