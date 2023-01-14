package service.comparator.integer;

import io.reader.Reader;
import service.comparator.interfaces.IntegerComparator;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class IntegerComparatorDesc implements IntegerComparator {

    @Override
    public Map.Entry<Reader, ?> getAimEntry(Map<Reader, String> pool) {
        Map<Reader, Integer> intPool =
                pool.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Integer.parseInt(entry.getValue()))
                );

        return Collections.max(intPool.entrySet(), Map.Entry.comparingByValue());
    }

}
