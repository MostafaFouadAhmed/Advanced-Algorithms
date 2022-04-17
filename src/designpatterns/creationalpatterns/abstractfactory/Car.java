package designpatterns.creationalpatterns.abstractfactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Car {

    private final CarType model;
    private final Location location;

    abstract void construct();

}
