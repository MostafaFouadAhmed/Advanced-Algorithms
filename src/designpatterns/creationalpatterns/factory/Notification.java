package designpatterns.creationalpatterns.factory;

public interface Notification {

    void notifyUser();

    int id = 0;

    default void test() {
        if (id == 0) {
            System.out.println("ID is ZERO");
        } else {
            System.out.println("ID is not ZERO");
        }
    }

}
