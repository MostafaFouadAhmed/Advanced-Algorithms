package cyclicdetection;

import java.util.List;

public class CyclicDetection {

    public void detectCycles(final List<Vertex> graph) {

        for (Vertex vertex : graph) {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        }

    }

    private void dfs(final Vertex vertex) {
        vertex.setBeingVisited(true);

        for (Vertex neighbour : vertex.getNeighbours()) {
            if (neighbour.isBeingVisited()) {
                System.out.println("Cycle Detected at vertex : "+ neighbour.getName());
                return;
            }
            if (!neighbour.isVisited()) {
                dfs(neighbour);
            }
        }

        vertex.setVisited(true);
        vertex.setBeingVisited(false);

    }

}
