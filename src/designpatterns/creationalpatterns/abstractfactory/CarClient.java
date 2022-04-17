package designpatterns.creationalpatterns.abstractfactory;

public class CarClient {

    public static void main(String[] args) {

        System.out.println(CarFactory.buildCar(CarType.MINI));
        System.out.println(CarFactory.buildCar(CarType.MICRO));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }

}
