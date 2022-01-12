package searchalgorithms;

import java.util.List;
import java.util.Stack;
import searchalgorithms.utils.Vertex;

public class DepthFirstSearch {

    private final Stack<Vertex> verticesStack;

    public DepthFirstSearch() {
        verticesStack = new Stack<>();
    }

    public void traverseClustersRecursively(List<Vertex> graph) {

        for (Vertex vertex : graph) {
            if (!vertex.isVisited() && !verticesStack.contains(vertex)) {
                traverseRecursively(vertex);
            }
        }
    }

    public void traverseRecursively(Vertex rootVertex) {

        if (rootVertex.getAdjacencyList().size() == 0) {
            return;
        }

        verticesStack.push(rootVertex);

        while (!verticesStack.isEmpty()){

            Vertex currentVertex = verticesStack.pop();
            currentVertex.setVisited(true);

            for (Vertex vertex : currentVertex.getAdjacencyList()) {

                if (!vertex.isVisited() && !verticesStack.contains(vertex)) {
                    verticesStack.push(vertex);
                }
            }

            if(verticesStack.isEmpty()) {
                System.out.println(currentVertex.getName());
            }
            else {
                System.out.print(currentVertex.getName() + " -> ");
            }

        }

    }
    
    
}
