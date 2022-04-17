package designpatterns.creationalpatterns.abstractfactory;

public class CarFactory {

    public static Car buildCar(final CarType carType) {

        if (CarType.MINI.equals(carType)) return IndiaCarFactory.buildCar(carType);
        if (CarType.LUXURY.equals(carType)) return UsaCarFactory.buildCar(carType);

        return DefaultFactory.buildCar(carType);
    }

}