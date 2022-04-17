package graphs.searchalgorithms.utils;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.Pair;

public class Graph {

    private static final List<Pair<Vertex,Vertex>> vertexPairs =  new ArrayList<>();

    public List<Vertex> createGraphUsingAdjacencyList(final int numberOfVertices, final List<Vertex> graph) {
        for (int i = 0; i < numberOfVertices; i++) {

            graph.add(Vertex.createVertexWithChar(numberToAlphabet(i+1)));
        }

        return graph;
    }

    private static Character numberToAlphabet(int num) {

        return (char)('A' + (num - 1) % 26);
    }

    public void setAdjacency(List<Pair<Vertex,Vertex>> pairList) {

        pairList.forEach(pair -> pair.left.addAdjacentVertex(pair.right));

    }

    public void setAdjacency(Pair<Vertex,Vertex> pair) {

       pair.left.addAdjacentVertex(pair.right);

    }

    public static List<Vertex> initializeDefaultGraphUsingAdjacencyList() {

        vertexPairs.clear();

        List<Vertex> graph = new ArrayList<>();
        Graph graphStructure = new Graph();

        graph = graphStructure.createGraphUsingAdjacencyList(8, graph);

        vertexPairs.add(Pair.of(graph.get(0),graph.get(1)));
        vertexPairs.add(Pair.of(graph.get(1),graph.get(0)));
        vertexPairs.add(Pair.of(graph.get(0),graph.get(5)));
        vertexPairs.add(Pair.of(graph.get(5),graph.get(0)));
        vertexPairs.add(Pair.of(graph.get(0),graph.get(6)));
        vertexPairs.add(Pair.of(graph.get(6),graph.get(0)));
        vertexPairs.add(Pair.of(graph.get(1),graph.get(2)));
        vertexPairs.add(Pair.of(graph.get(2),graph.get(1)));
        vertexPairs.add(Pair.of(graph.get(1),graph.get(3)));
        vertexPairs.add(Pair.of(graph.get(3),graph.get(1)));
        vertexPairs.add(Pair.of(graph.get(3),graph.get(4)));
        vertexPairs.add(Pair.of(graph.get(4),graph.get(3)));
        vertexPairs.add(Pair.of(graph.get(6),graph.get(7)));
        vertexPairs.add(Pair.of(graph.get(7),graph.get(6)));

        graphStructure.setAdjacency(vertexPairs);

        return graph;
    }

    public List<Vertex> initializeCustomGraphUsingAdjacencyList(final int numberOfVertices) {

        vertexPairs.clear();

        List<Vertex> graph = new ArrayList<>();
        Graph graphStructure = new Graph();

        graph = graphStructure.createGraphUsingAdjacencyList(numberOfVertices, graph);

        return graph;
    }

}
