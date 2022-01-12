package topologicalorder.shortestpath;

import java.util.Stack;
import org.apache.commons.lang3.tuple.Pair;
import topologicalorder.utils.Vertex;


public class TopologicalOrdering {

    private final Stack<Vertex> verticesStack;

    public TopologicalOrdering() {
        verticesStack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Pair<Vertex, Integer> adjVertex : vertex.getAdjacencyList()) {
            if(!adjVertex.getLeft().isVisited()) {
                dfs(adjVertex.getLeft());
            }
        }
        verticesStack.push(vertex);
    }

    public Stack<Vertex> getVerticesStack() {
        return verticesStack;
    }


}
