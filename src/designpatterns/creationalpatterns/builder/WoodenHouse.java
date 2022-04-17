package designpatterns.creationalpatterns.builder;

public class WoodenHouse implements HouseBuilder{

    private final House house = new House();

    @Override
    public void buildBasement() {
        house.setHouseBasement("Wooden Basement");
    }

    @Override
    public void buildStructure() {
        house.setHouseStructure("Wooden structure");
    }

    @Override
    public void buildRoof() {
        house.setHouseRoof("Wooden roof");
    }

    @Override
    public void buildInterior() {
        house.setHouseInterior("Wooden interior");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
