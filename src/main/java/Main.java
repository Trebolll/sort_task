import sorting.SortManager;

public class Main {

    public static void main(String[] args) {

        try {
            SortManager sortManager = new SortManager();
            sortManager.init(args);
            sortManager.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    }

