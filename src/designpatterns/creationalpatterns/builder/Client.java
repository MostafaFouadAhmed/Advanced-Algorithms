package designpatterns.creationalpatterns.builder;

public class Client {

    public static void main(String[] args) {

        CivilEngineer civilEngineerForWoodenHouse = new CivilEngineer(new WoodenHouse());
        CivilEngineer civilEngineerForConcreteHouse = new CivilEngineer(new ConcreteHouse());

        System.out.println(civilEngineerForWoodenHouse.buildHouse());
        System.out.println(civilEngineerForConcreteHouse.buildHouse());
    }


}
