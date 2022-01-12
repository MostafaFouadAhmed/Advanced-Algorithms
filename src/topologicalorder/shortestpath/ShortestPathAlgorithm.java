package topologicalorder.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import org.apache.commons.lang3.tuple.Pair;
import topologicalorder.utils.Vertex;

public class ShortestPathAlgorithm {

    private int minDistance;


    public ShortestPathAlgorithm() {
        minDistance = 0;
    }

    public void computeShortestPath(final Vertex source, final Vertex destination, final Stack<Vertex> topologicalStack) {

        Vertex currentVertex;

        final Stack<Vertex> tempTopologicalStack = resetVertices(source, topologicalStack);

        while (!tempTopologicalStack.isEmpty()) {

            currentVertex = tempTopologicalStack.pop();

            if (currentVertex.equals(source)) {

                processNextSteps(source, destination, currentVertex);

            }
        }
    }

    private void incrementDistance(int distance) {

        minDistance = minDistance + distance;
    }

    private Stack<Vertex> resetVertices(final Vertex sourceVertex, final Stack<Vertex> topologicalStack) {
        final Stack<Vertex> tempStack = new Stack<>();
        tempStack.addAll(topologicalStack);
        Vertex currentVertex;
        int currentIndex;
        sourceVertex.setShortestDistanceFromSource(0);

        while (!topologicalStack.isEmpty()) {
            currentIndex = topologicalStack.indexOf(topologicalStack.peek());
            currentVertex = topologicalStack.pop();
            currentVertex.setVisited(false);
            tempStack.set(currentIndex, currentVertex);
        }
        return tempStack;
    }

    private void processNextSteps(final Vertex source, final Vertex destination, final Vertex currentVertex) {

        int adjVertexMinDis;
        int adjVertexWeight;
        int distance = 0;
        Vertex currentVertexTemp = null;
        List<Vertex> visitedButIgnored = new ArrayList<>();

        if (Objects.nonNull(currentVertex)) {
            if (currentVertex.getAdjacencyList().size() == 0) {
                currentVertex.setVisited(true);
                minDistance = 0;
                processNextSteps(source, destination, source);
            }
        }

        if (Objects.nonNull(currentVertex)) {

            for (Pair<Vertex, Integer> nextVertexEdgePair : currentVertex.getAdjacencyList()) {

                if (nextVertexEdgePair.getLeft().equals(destination)) {
                    incrementDistance(nextVertexEdgePair.getRight());

                    System.out.println("Shortest distance between " + source.getName() + " and " + destination.getName() + " is " + minDistance);
                    return;
                }

                adjVertexWeight = nextVertexEdgePair.getRight();
                adjVertexMinDis = nextVertexEdgePair.getLeft().getShortestDistanceFromSource();

                if (adjVertexMinDis > adjVertexWeight && !nextVertexEdgePair.getLeft().isVisited()) {

                    visitedButIgnored.add(nextVertexEdgePair.getLeft());
                    nextVertexEdgePair.getLeft().setShortestDistanceFromSource(adjVertexWeight);
                    distance = nextVertexEdgePair.getLeft().getShortestDistanceFromSource();
                    currentVertexTemp = nextVertexEdgePair.getLeft();
                }
            }

            incrementDistance(distance);

            for (Vertex vertex : visitedButIgnored) {
                if (!vertex.equals(currentVertexTemp)) {
                    resetVertex(vertex);
                }
            }

            processNextSteps(source, destination, currentVertexTemp);
        }

        if (minDistance == 0) {
            System.out.println("There is no path between " + source.getName() + " and " + destination.getName());

        }

    }

    private void resetVertex(final Vertex vertex) {

        vertex.setVisited(false);
        vertex.setShortestDistanceFromSource(Integer.MAX_VALUE);
    }


}
