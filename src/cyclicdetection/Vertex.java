package cyclicdetection;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vertex {

    private String name;
    private boolean isBeingVisited;
    private boolean isVisited;
    private List<Vertex> neighbours;

    public static Vertex from(final String vertexName) {

        return Vertex.builder()
            .name(vertexName)
            .neighbours(new ArrayList<>())
            .isVisited(false)
            .isBeingVisited(false)
            .build();

    }
}
