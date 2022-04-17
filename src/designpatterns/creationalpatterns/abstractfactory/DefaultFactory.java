package designpatterns.creationalpatterns.abstractfactory;

public class DefaultFactory {

    static Car buildCar(CarType model) {

        switch (model) {

            case MICRO:
                return new MicroCar(Location.DEFAULT);

            case LUXURY:
                return new LuxuryCar(Location.DEFAULT);

            default:
                return new MiniCar(Location.DEFAULT);

        }
    }
}