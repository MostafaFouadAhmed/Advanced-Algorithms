package graphs.dijkstra;

import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void computePath (final Vertex sourceVertex) {

        sourceVertex.setDistanceFromSource(0);

        final PriorityQueue<Vertex> verticesHeap = new PriorityQueue<>();

        verticesHeap.add(sourceVertex);

        while (!verticesHeap.isEmpty()) {

            final Vertex currentVertex = verticesHeap.poll();

        }

    }

}
