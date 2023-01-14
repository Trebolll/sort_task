package service.comparator.interfaces;


import io.reader.Reader;
import service.comparator.interfaces.Comparator;

public interface StringComparator extends Comparator {
    default String getValue(Reader flow) {
        String value;

        if (flow.isFlowOver()) {
            return "";
        }
        try {
            value = flow.pickCurrentItem();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " " + "(Не удается распознать элемент)");
            value = getValue(flow);
        }
        return value;
    }
}
