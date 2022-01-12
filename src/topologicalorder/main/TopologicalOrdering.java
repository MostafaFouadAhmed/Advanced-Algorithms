package topologicalorder.main;

import java.util.Stack;
import searchalgorithms.utils.Vertex;

public class TopologicalOrdering {

    private final Stack<Vertex> verticesStack;

    public TopologicalOrdering() {
        verticesStack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex adjVertex : vertex.getAdjacencyList()) {
            if(!adjVertex.isVisited()) {
                dfs(adjVertex);
            }
        }
        verticesStack.push(vertex);
    }

    public Stack<Vertex> getVerticesStack() {
        return verticesStack;
    }

}
