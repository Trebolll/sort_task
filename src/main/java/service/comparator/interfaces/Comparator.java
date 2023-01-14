package service.comparator.interfaces;

import io.reader.Reader;

import java.util.Map;

public interface Comparator {

    Map.Entry<Reader, ?> getAimEntry(Map<Reader, String> pool);


    String getValue(Reader flow);
}
