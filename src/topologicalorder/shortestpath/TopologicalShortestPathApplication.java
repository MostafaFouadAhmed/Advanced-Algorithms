package topologicalorder.shortestpath;

import java.util.List;
import java.util.Stack;
import topologicalorder.utils.Vertex;

public class TopologicalShortestPathApplication {

    public static void main(String[] args) {

        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

        Vertex s = Vertex.from("S");
        Vertex a = Vertex.from("A");
        Vertex b = Vertex.from("B");
        Vertex c = Vertex.from("C");
        Vertex d = Vertex.from("D");
        Vertex e = Vertex.from("E");
        Vertex f = Vertex.from("F");
        Vertex g = Vertex.from("G");

        s.addAdjacentVertex(a,1);
        s.addAdjacentVertex(c,2);
        a.addAdjacentVertex(b,6);
        c.addAdjacentVertex(a,4);
        c.addAdjacentVertex(d,3);
        b.addAdjacentVertex(d,1);
        b.addAdjacentVertex(e,2);
        d.addAdjacentVertex(e,1);
        e.addAdjacentVertex(f,1);
        e.addAdjacentVertex(g,2);
        g.addAdjacentVertex(b,1);

        List<Vertex> graph = List.of(s,a,b,c,d,e);

        for (Vertex vertex : graph) {
            if (!vertex.isVisited()) {
                topologicalOrdering.dfs(vertex);
            }
        }

        final Stack<Vertex> verticesPath = topologicalOrdering.getVerticesStack();

        ShortestPathAlgorithm spa = new ShortestPathAlgorithm();

        spa.computeShortestPath(c, b, verticesPath);

    }

}
