package designpatterns.creationalpatterns.abstractfactory;

public class IndiaCarFactory {

    static Car buildCar(CarType model) {

        switch (model) {

            case MICRO:
                return new MicroCar(Location.INDIA);

            case MINI:
                return new MiniCar(Location.INDIA);

            case LUXURY:
                return new LuxuryCar(Location.INDIA);

            default:
                return new MiniCar(Location.DEFAULT);

        }
    }
}