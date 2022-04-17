package designpatterns.creationalpatterns.singleton;

public class Application {

    public static void main(String[] args) {

        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());

        System.out.println("=================================================");

        System.out.println(SingletonEager.getInstance());
        System.out.println(SingletonEager.getInstance());

        System.out.println("=================================================");

        System.out.println(SingletonStaticBlock.getInstance());
        System.out.println(SingletonStaticBlock.getInstance());

        System.out.println("=================================================");

        System.out.println(ThreadSafeSingleton.getInstance());
        System.out.println(ThreadSafeSingleton.getInstance());

        System.out.println("=================================================");

        System.out.println(BillPughSingleton.getInstance());
        System.out.println(BillPughSingleton.getInstance());

    }

}
