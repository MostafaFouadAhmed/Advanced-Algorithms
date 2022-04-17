package designpatterns.creationalpatterns.builder;

public class CivilEngineer {

    private final HouseBuilder houseBuilder;

    public CivilEngineer (HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse () {

        houseBuilder.buildBasement();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.buildInterior();

        return houseBuilder.getHouse();
    }

}
