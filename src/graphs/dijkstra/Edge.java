package graphs.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Edge {

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

}
