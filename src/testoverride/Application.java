package testoverride;

public class Application {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Animal dog = new Dog();
        Dog dog2 = new Dog();
        
        dog.print();
        animal.print();
        dog2.print();

    }

}
