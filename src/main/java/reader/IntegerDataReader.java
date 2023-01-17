package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegerDataReader implements DataReader<Integer> {

    public IntegerDataReader(List<File> fileList) throws IOException {
        readFiles(fileList);
    }

    private List<Integer> list = new ArrayList<>();


    @Override
    public void addToCollection(String line) {
        list.add(Integer.valueOf(line));
    }

    @Override
    public List<Integer> getList() {
        return list;
    }

}
