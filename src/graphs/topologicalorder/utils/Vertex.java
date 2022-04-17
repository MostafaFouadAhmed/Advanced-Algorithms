package graphs.topologicalorder.utils;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.Pair;

@Builder
@Data
public class Vertex {

    private String name;
    private boolean visited;
    private List<Pair<Vertex,Integer>> adjacencyList;
    private int shortestDistanceFromSource;

    public static Vertex from(final String vertexName) {

        return Vertex.builder()
            .name(vertexName)
            .adjacencyList(new ArrayList<>())
            .visited(false)
            .shortestDistanceFromSource(Integer.MAX_VALUE).build();

    }

    public void addAdjacentVertex(final Vertex vertex, final int weight) {

        this.adjacencyList.add(Pair.of(vertex,weight));
    }
}
