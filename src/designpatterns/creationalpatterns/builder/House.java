package designpatterns.creationalpatterns.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class House{

    private String houseBasement;
    private String houseStructure;
    private String houseRoof;
    private String houseInterior;

}
