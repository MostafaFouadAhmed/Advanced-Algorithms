package testoverride;

public class Dog extends Animal{

    @Override
    public void print () {
        System.out.println("Dog");
    }

    public static void dehk () {
        System.out.println("Dog De7k");
    }
}
