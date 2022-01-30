package searchalgorithms.utils;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

@Builder
@Data
public class Vertex {

    private String name;
    private int vertexValue;
    private boolean visited;
    private List<Vertex> adjacencyList;
    private Pair<Integer, Integer> vertexIndex;

    public static Vertex createVertexWithChar(final Character vertexName) {

       return Vertex.builder()
           .name(vertexName.toString())
           .adjacencyList(new ArrayList<>())
           .visited(false)
           .build();
    }

    public static Vertex createVertex(final int vertexValue) {

        return Vertex.builder()
            .vertexValue(vertexValue)
            .adjacencyList(new ArrayList<>())
            .visited(false)
            .build();
    }

    public void addAdjacentVertex(final Vertex vertex) {

        this.adjacencyList.add(vertex);
    }
}
