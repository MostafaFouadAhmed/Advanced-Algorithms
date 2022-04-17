package designpatterns.creationalpatterns.builder;

public class ConcreteHouse implements HouseBuilder{

    private final House house = new House();

    @Override
    public void buildBasement() {
        house.setHouseBasement("Concrete Basement");
    }

    @Override
    public void buildStructure() {
        house.setHouseStructure("Concrete structure");
    }

    @Override
    public void buildRoof() {
        house.setHouseRoof("Concrete roof");
    }

    @Override
    public void buildInterior() {
        house.setHouseInterior("Concrete interior");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
