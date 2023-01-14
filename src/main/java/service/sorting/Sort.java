package service.sorting;



import io.reader.Reader;
import io.writer.Writer;
import service.comparator.interfaces.Comparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort {

    private Writer result;
    private List<Reader> flows = new ArrayList<>();
    private Comparator comparator;
    private Map<Reader, String> pool = new HashMap<>();

    private Sort(Build build) {
        if (build != null) {
            result = build.writer;
            comparator = build.comparator;
            flows.addAll(build.readers);
        }
    }

    public static class Build {
        private Writer writer;
        private Comparator comparator;
        private List<Reader> readers = new ArrayList<>();

        public Sort.Build writer(Writer item) {
            writer = item;
            return this;
        }

        public Sort.Build comparator(Comparator comparator) {
            this.comparator = comparator;
            return this;
        }

        public Sort.Build addFlows(List<Reader> flows) {
            if (flows == null) {
                return this;
            }
            readers.addAll(flows);
            return this;
        }

        public Sort build() {
            return new Sort(this);
        }
    }

    public void sorting() {

        for (Reader flow : flows) {
            if (!flow.isFlowOver()) {
                pool.put(flow, comparator.getValue(flow));
            }
        }

        while (!pool.isEmpty()) {
            Map.Entry<Reader, ?> item = comparator.getAimEntry(pool);
            result.write(item.getValue().toString());
            if (item.getKey().isFlowOver()) {
                pool.remove(item.getKey());
            } else {
                pool.put(item.getKey(), comparator.getValue(item.getKey()));
            }
        }
    }
}