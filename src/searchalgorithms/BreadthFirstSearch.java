package searchalgorithms;

import java.util.LinkedList;
import java.util.Queue;
import utils.Vertex;

public class BreadthFirstSearch {

    private final Queue<Vertex> notVisitedVertices = new LinkedList<>();

    public void traverse(Vertex rootVertex) {

        notVisitedVertices.add(rootVertex);

        while (!notVisitedVertices.isEmpty()) {
            Vertex currentVertex = notVisitedVertices.remove();
            currentVertex.setVisited(true);

            System.out.println("Current Vertex: "+currentVertex.getName());

            for (Vertex vertex : currentVertex.getAdjacencyList()) {
                if (!vertex.isVisited()) {
                    notVisitedVertices.add(vertex);
                }
            }
        }
    }
    
}
