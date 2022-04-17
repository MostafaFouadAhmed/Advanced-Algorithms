package graphs.cyclicdetection;

import java.util.List;

public class App {

    public static void main(String[] args) {

        final Vertex a = Vertex.from("A");
        final Vertex b = Vertex.from("B");
        final Vertex c = Vertex.from("C");
        final Vertex d = Vertex.from("D");
        final Vertex e = Vertex.from("E");
        final Vertex f = Vertex.from("F");

        a.setNeighbours(List.of(c,e));
        c.setNeighbours(List.of(b,f));
        d.setNeighbours(List.of(a));
        e.setNeighbours(List.of(d));


        final List<Vertex> graph = List.of(d,b,c,a,e);

        final CyclicDetection detection = new CyclicDetection();

        detection.detectCycles(graph);

    }
}
