package testoverride;

import java.util.List;

public interface Parent {

    static void print() {
        System.out.println("medhat");
    }

    List<String > strings = List.of("asd", "asf");

}
