package designpatterns.creationalpatterns.singleton;

public class BillPughSingleton {

    private final int ID;
    private final String NAME;

    private BillPughSingleton(int id, String name) {
        ID = id;
        NAME = name;

    }

    private static final class BillPughSingletonHolder {

        private static final BillPughSingleton billPughSingleton = new BillPughSingleton(50, "BillPughSingleton");

    }


    public static BillPughSingleton getInstance() {

        return BillPughSingletonHolder.billPughSingleton;
    }

    @Override
    public String toString() {

        return "BillPughSingleton{" +
            "ID=" + ID +
            ", NAME='" + NAME + '\'' +
            '}';
    }

}
