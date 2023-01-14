package io.reader;

public interface Reader {
    String getCurrentItem();
    String pickCurrentItem();
    boolean isFlowOver();
}
