package designpatterns.creationalpatterns.singleton;

public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private final int id;
    private final String name;

    private SingletonLazy(int id, String name){

        this.id = id;
        this.name = name;

    }

    public static SingletonLazy getInstance() {

        if (singletonLazy == null){

            singletonLazy = new SingletonLazy(10, "SingletonLazy");
        }

        return singletonLazy;
    }

    @Override
    public String toString() {

        return "SingletonLazy{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

}