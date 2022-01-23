package topologicalorder.main;

import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.tuple.Pair;

public class TopologicalOrderingApplication {

    public static void main(String[] args) {

        final TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        final Graph customizedGraph = new Graph();

        List<Vertex> customGraphList = List.of(
            Vertex.createVertexWithString("0"),
            Vertex.createVertexWithString("1"),
            Vertex.createVertexWithString("2"),
            Vertex.createVertexWithString("3"),
            Vertex.createVertexWithString("4"),
            Vertex.createVertexWithString("5")
            );
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(3),customGraphList.get(1)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(4),customGraphList.get(1)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(4),customGraphList.get(0)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(5),customGraphList.get(0)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(5),customGraphList.get(2)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(2),customGraphList.get(3)));

        for (Vertex vertex : customGraphList) {

            if (!vertex.isVisited()) {
                topologicalOrdering.dfs(vertex);
            }
        }

        final Stack<Vertex> stack = topologicalOrdering.getVerticesStack();

        for (int i = 0; i < customGraphList.size(); i++){
            System.out.println(stack.pop().getName());
        }

    }

}
