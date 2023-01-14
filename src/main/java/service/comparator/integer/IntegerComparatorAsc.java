package service.comparator.integer;

import io.reader.Reader;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class IntegerComparatorAsc implements IntegerComparator{

    @Override
    public Map.Entry<Reader, ?> getAimEntry(Map<Reader, String> pool) {
        Map<Reader, Integer> integerMap =
                pool.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Integer.parseInt(entry.getValue()))
                );
        return Collections.min(integerMap.entrySet(), Map.Entry.comparingByValue());
    }

}
