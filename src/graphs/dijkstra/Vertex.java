package graphs.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Vertex implements Comparable<Vertex> {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;
    private double distanceFromSource;
    private Vertex predecessor;

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distanceFromSource, otherVertex.distanceFromSource);
    }
}
