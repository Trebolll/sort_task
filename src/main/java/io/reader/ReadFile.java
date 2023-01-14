package io.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile implements  Reader{
    private boolean flowOverFlag = false;
    private String currentItemOfFlow;
    private Scanner scanner;

    public ReadFile(File file) {
        try {
            this.scanner = new Scanner(file);
            if (scanner.hasNext()) {
                currentItemOfFlow = scanner.next();
            } else {
                flowOverFlag = true;
                System.out.println(file.getName() + " " + "Не удается получить элементы, файл пуст");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCurrentItem() {
        return currentItemOfFlow;
    }

    @Override
    public String pickCurrentItem() {
        String valueOfCurrentItem = getCurrentItem();

        if (scanner == null) {
            flowOverFlag = true;
            return "";
        }
        if (scanner.hasNext()) {
            currentItemOfFlow = scanner.next();
        } else {
            flowOverFlag = true;
        }
        return valueOfCurrentItem;
    }

    @Override
    public boolean isFlowOver() {
        return flowOverFlag;
    }
}


