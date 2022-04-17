package designpatterns.creationalpatterns.abstractfactory;

public class UsaCarFactory {

    static Car buildCar(CarType model) {

        switch (model) {

            case MICRO:
                return new MicroCar(Location.USA);

            case MINI:
                return new MiniCar(Location.USA);

            case LUXURY:
                return new LuxuryCar(Location.USA);

            default:
                return new MiniCar(Location.DEFAULT);

        }
    }

}
