package controller;
import io.reader.Reader;
import io.writer.Writer;
import service.comparator.Comparator;
import service.comparator.integer.IntegerComparatorAsc;
import service.comparator.integer.IntegerComparatorDesc;
import service.comparator.string.StringComparatorAsc;
import service.comparator.string.StringComparatorDesc;
import service.sorting.Sort;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Writer writer;
    private Comparator comparator;
    private List<Reader> readers = new ArrayList<>();

    public Controller(boolean isDescSorting, boolean isStringSorting,
                      Writer writer, List<Reader> listOfReaders) {
        this.comparator = selectComparator(isDescSorting, isStringSorting);
        this.writer = writer;
        this.readers.addAll(listOfReaders);
    }

    private Comparator selectComparator(boolean isIntegerSorting, boolean isStringSorting) {
        if (isIntegerSorting) {
            return (isStringSorting) ? new StringComparatorDesc() : new IntegerComparatorDesc();

        } else {
            return (isStringSorting) ? new StringComparatorAsc() : new IntegerComparatorAsc();

        }
    }

    public void execute() {
        Sort sorter = new Sort.Build()
                .writer(writer)
                .comparator(comparator)
                .addFlows(readers)
                .build();
        sorter.sorting();
        printComplete();
    }

    private void printComplete() {
        String header = "=== Completed ===";
        System.out.println(header);
    }
}
