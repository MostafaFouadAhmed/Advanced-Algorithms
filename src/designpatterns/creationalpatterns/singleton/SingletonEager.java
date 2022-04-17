package designpatterns.creationalpatterns.singleton;

public class SingletonEager {

    private static final SingletonEager SINGLETON_EAGER = new SingletonEager(10, "SingletonEager");

    private final int ID;
    private final String NAME;

    public static int numberOfObjects = 0;

    private SingletonEager(int id, String name){

        numberOfObjects++;
        this.ID = id;
        this.NAME = name;

    }

    public static SingletonEager getInstance() {

        return SINGLETON_EAGER;
    }

    @Override
    public String toString() {

        return "SingletonEager{" +
            "id=" + ID +
            ", name='" + NAME + '\'' +
            '}';
    }

}
