package designpatterns.creationalpatterns.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton threadSafeSingleton;

    private final int ID;
    private final String NAME;

    private ThreadSafeSingleton(int id, String name) {
        ID = id;
        NAME = name;
    }

    public static ThreadSafeSingleton getInstance() {

        if (threadSafeSingleton == null) {

            synchronized (ThreadSafeSingleton.class) {

                if (threadSafeSingleton == null) {

                    threadSafeSingleton = new ThreadSafeSingleton(50, "ThreadSafeClass");
                }
            }
        }

        return threadSafeSingleton;

    }

    @Override
    public String toString() {

        return "ThreadSafeSingleton{" +
            "ID=" + ID +
            ", NAME='" + NAME + '\'' +
            '}';
    }

}
